package com.rebolledonaharro.dinoapi.usuario.error;

import com.rebolledonaharro.dinoapi.ErrorMessage;
import com.rebolledonaharro.dinoapi.usuario.model.User;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler({UsernameNotFound.class})
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFound ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.of(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler({NoAdmin.class})
    public ResponseEntity<?> handleNoAdminException(NoAdmin ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorMessage.of(HttpStatus.UNAUTHORIZED,ex.getMessage(),request.getRequestURI()));
    }


}
