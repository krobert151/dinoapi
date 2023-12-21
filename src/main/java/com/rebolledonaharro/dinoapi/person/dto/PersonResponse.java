package com.rebolledonaharro.dinoapi.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rebolledonaharro.dinoapi.person.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PersonResponse {

    protected String id;
    protected String username, fullName;
    protected Set<String> roles;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime createdAt;


    public static PersonResponse fromUser(Person person) {

        return PersonResponse.builder()
                .id(person.getId().toString())
                .username(person.getUsername())
                .fullName(person.getName()+" "+person.getLastName())
                .roles(person.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()))
                .createdAt(person.getCreatedAt())
                .build();
    }

}
