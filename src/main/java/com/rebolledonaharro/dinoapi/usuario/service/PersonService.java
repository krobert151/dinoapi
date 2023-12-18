package com.rebolledonaharro.dinoapi.usuario.service;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import com.rebolledonaharro.dinoapi.usuario.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Optional<Person> findByUsername (String username){
        return repository.findFirstByUsername(username);
    }

    public boolean checkPasswordExpired(UUID uuid){
        Person person = repository.findFristById(uuid);


        System.out.println(person.getPasswordExpirateAt()+ "Expirated");
        System.out.println(LocalDateTime.now()+"Now");
        if(person.getPasswordExpirateAt().isBefore(LocalDateTime.now())) {
            return true;
        }
        return false;

    }

    public void disableExpiratedPassword(Person person){
        person.setCredentialsNonExpired(false);
        repository.save(person);
    }

    public void restorePassword(Person person){

    }
    public Optional<Person> findById(UUID userId) {
        return repository.findById(userId);
    }
}
