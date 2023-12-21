package com.rebolledonaharro.dinoapi.person.dto;

import com.rebolledonaharro.dinoapi.person.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@ValidPassword
public record CreatePersonRequest(

        @NotNull(message = "username can`t be null")
        @NotBlank(message = "username can`t be black")
        String username,

        @NotNull(message = "email can`t be null")
        String email,

        @NotNull(message = "name can`t be null")
        String name,

        @NotNull(message = "last name can`t be null")
        String lastName,

        String password,

        String verifyPassword,

        @NotNull(message = "phone number can`t be null")
        String phoneNumber

) {
}