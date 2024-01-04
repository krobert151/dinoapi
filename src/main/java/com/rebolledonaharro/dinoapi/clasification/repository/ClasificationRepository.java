package com.rebolledonaharro.dinoapi.clasification.repository;

import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClasificationRepository extends JpaRepository<Classification, UUID> {


    Optional<Classification> findFirstByName (String name);

}
