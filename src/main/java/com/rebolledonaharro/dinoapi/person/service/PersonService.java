package com.rebolledonaharro.dinoapi.person.service;

import com.rebolledonaharro.dinoapi.person.dto.RestorePassword;
import com.rebolledonaharro.dinoapi.person.model.Person;
import com.rebolledonaharro.dinoapi.person.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    private final PasswordEncoder passwordEncoder;

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

    public Person restorePassword(RestorePassword restorePassword) throws UserPrincipalNotFoundException {

        Optional<Person> optionalPerson = repository.findFirstByUsername(restorePassword.username());

        if(optionalPerson.isEmpty())
            throw new UserPrincipalNotFoundException("Username with name "+ restorePassword.username()+" not found");

        Person person = optionalPerson.get();

        if(!passwordEncoder.matches(restorePassword.oldPassword(), person.getPassword())) {
            throw new EntityNotFoundException("Old password not found ");
        }

        person.setPassword(passwordEncoder.encode(restorePassword.password()));

        person.setEnabled(true);

        person.setCredentialsNonExpired(true);

        person.setLastPasswordChangeAt(LocalDateTime.now());

        person.setPasswordExpirateAt(LocalDateTime.now().plusMonths(3));

        return repository.save(person);

    }
    public Optional<Person> findById(UUID userId) {
        return repository.findById(userId);
    }
}
