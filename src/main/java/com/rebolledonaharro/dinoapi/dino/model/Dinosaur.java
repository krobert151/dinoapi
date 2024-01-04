package com.rebolledonaharro.dinoapi.dino.model;

import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.period.model.Period;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Builder

public class Dinosaur {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
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
    @Column(nullable = false, columnDefinition = "uuid")
    private UUID id;

    @ToString.Include
    @Column(unique = true)
    private String scientificName;

    @ToString.Include
    private String name;


    @ToString.Include
    @Column(nullable = false)
    private double height;

    @ToString.Include
    @Column(nullable = false)
    private double weight;

    @ToString.Include
    @Column(nullable = false)
    private double length;

    @ToString.Include
    @Column(nullable = false)
    private double liveSince;

    @ToString.Include
    @Column(nullable = false)
    private double liveUntil;

    //associate articles

    //associate paleontologist

    //associate films, movies and cartoons

    @ToString.Include
    @Column(nullable = false)
    private int numTheeth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clasification_id", nullable = false)
    private Classification classification;

    @ManyToMany
    @ToString.Exclude
    private List<Period> periods = new ArrayList<>();

//associate prey

    //associate predators

    //associate zones


}
