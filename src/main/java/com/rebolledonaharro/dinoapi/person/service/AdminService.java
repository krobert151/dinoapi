package com.rebolledonaharro.dinoapi.person.service;

import com.rebolledonaharro.dinoapi.person.dto.CreatePersonRequest;
import com.rebolledonaharro.dinoapi.person.error.NonAdminException;
import com.rebolledonaharro.dinoapi.person.model.Admin;
import com.rebolledonaharro.dinoapi.person.model.Person;
import com.rebolledonaharro.dinoapi.person.model.PersonRole;
import com.rebolledonaharro.dinoapi.person.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.EnumSet;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;


    public Admin createUser(CreatePersonRequest createPersonRequest, EnumSet<PersonRole> roles){
        if (repository.existsByUsernameIgnoreCase(createPersonRequest.username()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El email del usuario ya ha sido registrado");



        Admin admin = Admin.builder()
                .username(createPersonRequest.username())
                .email(createPersonRequest.email())
                .name(createPersonRequest.name())
                .lastName(createPersonRequest.lastName())
                .createdAt(LocalDateTime.now())
                .password(passwordEncoder.encode(createPersonRequest.password()))
                .roles(roles)
                .build();
        return repository.save(admin);

    }

    public Admin createPersonWithAdminRole(CreatePersonRequest createPersonRequest, Person person){

        if(!person.getRoles().contains(PersonRole.ADMIN)){
            throw new NonAdminException(person.getName()+" is not an administrator");
        }

        return createUser(createPersonRequest,EnumSet.of(PersonRole.ADMIN));
    }

}
