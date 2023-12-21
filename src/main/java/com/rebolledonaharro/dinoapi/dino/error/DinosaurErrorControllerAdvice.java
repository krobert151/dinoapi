package com.rebolledonaharro.dinoapi.dino.error;

import com.rebolledonaharro.dinoapi.ErrorMessage;
import com.rebolledonaharro.dinoapi.person.error.UsernameNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DinosaurErrorControllerAdvice {

    @ExceptionHandler({DinosaurNotFoundException.class})
    public ResponseEntity<?> handleDinosaurNotFoundException(DinosaurNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.of(HttpStatus.NOT_FOUND,ex.getMessage(),request.getRequestURI()));
    }


}
