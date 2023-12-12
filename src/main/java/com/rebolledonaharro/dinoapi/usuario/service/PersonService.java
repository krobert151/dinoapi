package com.rebolledonaharro.dinoapi.usuario.service;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import com.rebolledonaharro.dinoapi.usuario.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Optional<Person> findByUsername (String username){
        return repository.findFirstByUsername(username);
    }


    public Optional<Person> findById(UUID userId) {
        return repository.findById(userId);
    }
}
