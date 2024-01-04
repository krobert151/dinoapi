package com.rebolledonaharro.dinoapi.period.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Period {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO, generator = "UUID")
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
    private String name;

    @ToString.Include
    @Column(nullable = false)
    private double started;

    @ToString.Include
    @Column(nullable = false)
    private double finished;


    @ToString.Include
    @Column(columnDefinition = "TEXT")
    private String description;


}
