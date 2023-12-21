package com.rebolledonaharro.dinoapi.security.jwt.access;

import com.rebolledonaharro.dinoapi.security.errorhandling.BlackListTokenException;
import com.rebolledonaharro.dinoapi.security.errorhandling.JwtTokenException;
import com.rebolledonaharro.dinoapi.security.errorhandling.PasswordExpired;
import com.rebolledonaharro.dinoapi.person.model.Person;
import com.rebolledonaharro.dinoapi.person.service.PersonService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@Log
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final PersonService personService;

    @Autowired
    private final JwtProvider jwtProvider;


    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtTokenFromRequest(request);

        try {

                if (StringUtils.hasText(token) && jwtProvider.validateToken(token)) {
                    UUID userId = jwtProvider.getUserIdFromJwtToken(token);

                    Optional<Person> result = personService.findById(userId);
                    if (result.isPresent()) {
                        Person person = result.get();
                        if(personService.checkPasswordExpired(person.getId()))
                            personService.disableExpiratedPassword(person);

                        if(!person.isCredentialsNonExpired())
                            throw new PasswordExpired("Su contraseña ha expirado");

                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        person,
                                        null,
                                        person.getAuthorities()
                                );

                        authentication.setDetails(new WebAuthenticationDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }

                }

                filterChain.doFilter(request, response);

        } catch (JwtTokenException | BlackListTokenException | PasswordExpired ex) {
            log.info("Authentication error using token JWT: " + ex.getMessage());
            resolver.resolveException(request, response, null, ex);
        }


    }

    private String getJwtTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtProvider.TOKEN_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtProvider.TOKEN_PREFIX)) {
            return bearerToken.substring(JwtProvider.TOKEN_PREFIX.length());
        }
        return null;
    }
}
