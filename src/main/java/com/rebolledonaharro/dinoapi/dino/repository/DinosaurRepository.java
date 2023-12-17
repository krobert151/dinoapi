package com.rebolledonaharro.dinoapi.dino.repository;

import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DinosaurRepository extends JpaRepository<Dinosaur, UUID> {
}
