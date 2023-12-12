package com.rebolledonaharro.dinoapi.usuario.controller;

import com.rebolledonaharro.dinoapi.security.jwt.access.JwtProvider;
import com.rebolledonaharro.dinoapi.usuario.dto.CreatePersonRequest;
import com.rebolledonaharro.dinoapi.usuario.dto.JwtUserResponse;
import com.rebolledonaharro.dinoapi.usuario.dto.LoginRequest;
import com.rebolledonaharro.dinoapi.usuario.dto.PersonResponse;
import com.rebolledonaharro.dinoapi.usuario.model.Admin;
import com.rebolledonaharro.dinoapi.usuario.model.Person;
import com.rebolledonaharro.dinoapi.usuario.model.User;
import com.rebolledonaharro.dinoapi.usuario.service.AdminService;
import com.rebolledonaharro.dinoapi.usuario.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authManager;
    private final UserService userService;
    private final AdminService adminService;

    @PostMapping("/auth/register")
    public ResponseEntity<PersonResponse> createPersonWithUserRole(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        User user = userService.createPersonWithUserRole(createPersonRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.fromUser(user));
    }

    @PostMapping("/admin/register")
    public ResponseEntity<PersonResponse> createPersonWithAdminRole(@Valid @RequestBody CreatePersonRequest createPersonRequest, @AuthenticationPrincipal Person person){
        Admin admin = adminService.createPersonWithAdminRole(createPersonRequest, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.fromUser(admin));
    }


    @PostMapping("/auth/login")
    public ResponseEntity<JwtUserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        Person person = (Person) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(JwtUserResponse.of(person, token));
    }

}
