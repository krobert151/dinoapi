package com.rebolledonaharro.dinoapi.person.repository;

import com.rebolledonaharro.dinoapi.person.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {

    boolean existsByUsernameIgnoreCase(String username);


}
