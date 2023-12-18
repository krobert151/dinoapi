package com.rebolledonaharro.dinoapi.usuario.repository;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    boolean existsByUsernameIgnoreCase(String username);

    Person findFristById(UUID uuid);

    Optional<Person> findFirstByUsername(String username);

}
