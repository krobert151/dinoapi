package com.rebolledonaharro.dinoapi.usuario.repository;

import com.rebolledonaharro.dinoapi.usuario.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
