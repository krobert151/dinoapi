package com.rebolledonaharro.dinoapi.person.service;

import com.rebolledonaharro.dinoapi.person.dto.CreatePersonRequest;
import com.rebolledonaharro.dinoapi.person.model.PersonRole;
import com.rebolledonaharro.dinoapi.person.model.User;
import com.rebolledonaharro.dinoapi.person.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.EnumSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    public User createUser(CreatePersonRequest createPersonRequest, EnumSet<PersonRole> roles){
        if (repository.existsByUsernameIgnoreCase(createPersonRequest.username()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El email del usuario ya ha sido registrado");

        User user = User.builder()
                .username(createPersonRequest.username())
                .email(createPersonRequest.email())
                .name(createPersonRequest.name())
                .lastName(createPersonRequest.lastName())
                .createdAt(LocalDateTime.now())
                .password(passwordEncoder.encode(createPersonRequest.password()))
                .roles(roles)
                .build();
        return repository.save(user);

    }

    public User createPersonWithUserRole(CreatePersonRequest createPersonRequest){
        return createUser(createPersonRequest,EnumSet.of(PersonRole.USER));
    }


}
