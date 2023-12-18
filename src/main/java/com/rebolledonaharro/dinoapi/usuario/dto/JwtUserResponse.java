package com.rebolledonaharro.dinoapi.usuario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtUserResponse extends PersonResponse {

    private String token;
    private String refreshToken;

    public JwtUserResponse(PersonResponse userResponse) {
        id = userResponse.getId();
        username = userResponse.getUsername();
        fullName = userResponse.getFullName();
        roles=userResponse.getRoles();
        createdAt = userResponse.getCreatedAt();
    }

    public static JwtUserResponse of (Person person, String token, String refreshToken) {
        JwtUserResponse result = new JwtUserResponse(PersonResponse.fromUser(person));
        result.setToken(token);
        result.setRefreshToken(refreshToken);
        return result;

    }

}