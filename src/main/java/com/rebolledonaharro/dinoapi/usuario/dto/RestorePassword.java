package com.rebolledonaharro.dinoapi.usuario.dto;

import com.rebolledonaharro.dinoapi.usuario.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestorePassword (

        @NotNull(message = "username can`t be null")
        @NotBlank(message = "username can`t be black")
        String username,

        @NotNull(message = "old password can`t be null")
        @NotBlank(message = "old password can`t be black")
        String oldPassword,

        String password,

        String verifyPassword
) {


}
