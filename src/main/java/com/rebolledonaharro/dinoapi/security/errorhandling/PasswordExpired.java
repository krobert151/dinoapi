package com.rebolledonaharro.dinoapi.security.errorhandling;

import javax.naming.AuthenticationException;

public class PasswordExpired extends AuthenticationException {

    public PasswordExpired() {
        super();
    }

    public PasswordExpired(String message) {
        super(message);
    }


}
