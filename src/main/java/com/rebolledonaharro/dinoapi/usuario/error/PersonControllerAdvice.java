package com.rebolledonaharro.dinoapi.usuario.error;

import com.rebolledonaharro.dinoapi.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler({NoAdmin.class})
    public ResponseEntity<?> handleNoAdminException(NoAdmin ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorMessage.of(HttpStatus.UNAUTHORIZED,ex.getMessage(),request.getRequestURI()));
    }


}
