package com.rebolledonaharro.dinoapi.clasification.repository;

import com.rebolledonaharro.dinoapi.clasification.model.Clasification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClasificationRepository extends JpaRepository<Clasification, UUID> {
}
