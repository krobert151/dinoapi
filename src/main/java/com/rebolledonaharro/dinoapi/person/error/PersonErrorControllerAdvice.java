package com.rebolledonaharro.dinoapi.person.error;

import com.rebolledonaharro.dinoapi.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class PersonErrorControllerAdvice {

    @ExceptionHandler({UsernameNotFoundException.class})
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.of(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler({NonAdminException.class})
    public ResponseEntity<?> handleNoAdminException(NonAdminException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorMessage.of(HttpStatus.UNAUTHORIZED,ex.getMessage(),request.getRequestURI()));
    }


}
