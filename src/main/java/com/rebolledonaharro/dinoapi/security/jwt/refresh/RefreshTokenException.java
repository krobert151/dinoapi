package com.rebolledonaharro.dinoapi.security.jwt.refresh;

import com.rebolledonaharro.dinoapi.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {
    public RefreshTokenException(String msg) {
        super(msg);
    }
}
