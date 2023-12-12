package com.rebolledonaharro.dinoapi.usuario.repository;

import com.rebolledonaharro.dinoapi.usuario.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsernameIgnoreCase(String username);

    Optional<User> findFirstByUsername(String username);

}
