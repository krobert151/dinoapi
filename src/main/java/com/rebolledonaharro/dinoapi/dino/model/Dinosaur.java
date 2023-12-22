package com.rebolledonaharro.dinoapi.dino.model;

import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.period.model.Period;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.LinkedHashSet;
import java.util.Set;
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


    private float height;

    private float weight;

    private float length;

    private double liveSince;

    private double liveUntil;

    //associate articles

    //associate paleontologist

    //associate films, movies and cartoons

    private int numTheeth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clasification_id", nullable = false)
    private Classification classification;

    @OneToMany
    private Set<Period> periods = new LinkedHashSet<>();

//associate prey

    //associate predators

    //associate zones


}
