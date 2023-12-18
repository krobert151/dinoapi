package com.rebolledonaharro.dinoapi.usuario.error;

import jakarta.persistence.EntityNotFoundException;

public class UsernameNotFound extends EntityNotFoundException {


    public UsernameNotFound() {
        super();
    }

    public UsernameNotFound(Exception cause) {
        super(cause);
    }
}
