package com.rebolledonaharro.dinoapi.dino.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dinosaur {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(unique = true)
    private String cientificName;

    private String name;

    //new Class of Gender

    private float height;

    private float weight;

    private float length;

    //associate period (from to millions ago)

    //associate articles

    //associate paleontologist

    //associate films, movies and cartoons

    private int numTheeth;

    //associate pray

    //associate zones


}
