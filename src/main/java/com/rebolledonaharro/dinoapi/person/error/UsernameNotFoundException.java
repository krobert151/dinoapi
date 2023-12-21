package com.rebolledonaharro.dinoapi.person.error;

import jakarta.persistence.EntityNotFoundException;

public class UsernameNotFoundException extends EntityNotFoundException {


    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(Exception cause) {
        super(cause);
    }
}
