package com.rebolledonaharro.dinoapi.person.repository;

import com.rebolledonaharro.dinoapi.person.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsernameIgnoreCase(String username);

    Optional<User> findFirstByUsername(String username);

}
