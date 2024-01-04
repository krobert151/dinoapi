package com.rebolledonaharro.dinoapi.dino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DinoPOST(

        @NotBlank(message = "name can´t be blank")
        String name,
        @NotBlank(message = "scientific name can´t be blank")
        String scientificName,

        int numTheeth,

        @NotNull
        double height,

        @NotNull
        double weight,

        @NotNull
        double lenght,

        double liveSince,

        double liveUntil,


        String family

) {
}
