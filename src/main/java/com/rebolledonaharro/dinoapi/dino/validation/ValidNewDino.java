package com.rebolledonaharro.dinoapi.dino.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidatorNewDino.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNewDino {

    String message() default "Runs invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
