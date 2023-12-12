package com.rebolledonaharro.dinoapi.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rebolledonaharro.dinoapi.usuario.validation.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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