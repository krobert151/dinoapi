package com.rebolledonaharro.dinoapi.person.error;

public class NonAdminException extends RuntimeException{
    public NonAdminException(String message) {
        super(message);
    }
}
