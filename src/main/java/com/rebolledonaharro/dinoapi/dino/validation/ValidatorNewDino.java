package com.rebolledonaharro.dinoapi.dino.validation;

import com.rebolledonaharro.dinoapi.dino.dto.DinoPOST;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorNewDino implements ConstraintValidator<ValidNewDino, DinoPOST> {
    @Override
    public boolean isValid(DinoPOST post, ConstraintValidatorContext constraintValidatorContext) {

        return !(post.liveSince() > post.liveUntil());
    }
}
