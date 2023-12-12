package com.rebolledonaharro.dinoapi.usuario.validation;

import com.rebolledonaharro.dinoapi.usuario.dto.CreatePersonRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidatorPassword implements ConstraintValidator<ValidPassword, CreatePersonRequest> {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");


    @Override
    public boolean isValid(CreatePersonRequest createPersonRequest, ConstraintValidatorContext constraintValidatorContext) {
        String password = createPersonRequest.password();
        if(!password.equals(createPersonRequest.verifyPassword()))
            return false;

        return textPattern.matcher(password).matches();


    }
}
