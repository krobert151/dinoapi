package com.rebolledonaharro.dinoapi.usuario.error;

public class NoAdmin extends RuntimeException{
    public NoAdmin(String message) {
        super(message);
    }
}
