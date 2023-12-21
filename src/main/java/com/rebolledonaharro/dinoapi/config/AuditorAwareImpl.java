package com.rebolledonaharro.dinoapi.config;

import com.rebolledonaharro.dinoapi.person.model.Person;
import lombok.extern.java.Log;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.*;

import java.util.Optional;
import java.util.UUID;

@Log
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .filter(principal -> principal instanceof Person)
                .map(Person.class::cast)
                .map(Person::getId)
                .map(UUID::toString);


    }
}
