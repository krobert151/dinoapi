package com.rebolledonaharro.dinoapi.dino.error;

import jakarta.persistence.EntityNotFoundException;

public class DinosaurNotFoundException extends EntityNotFoundException {

    public DinosaurNotFoundException() {
        super();
    }



    public DinosaurNotFoundException(String message) {
        super(message);
    }


}
