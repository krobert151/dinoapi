package com.rebolledonaharro.dinoapi.dino.repository;

import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DinosaurRepository extends JpaRepository<Dinosaur, UUID>, JpaSpecificationExecutor<Dinosaur> {

    public Dinosaur findFirstByName(String name);



    @Query("""
            Select d From Dinosaur d 
            Left Join d.periods as p 
            where p.name = ?1
            """)
    public List<Dinosaur> findByPeriodName(String periodName);




}
