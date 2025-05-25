package com.codestatest.crud_angular_spring.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = { FechaPasadaValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaPasada {
    String message() default "La fecha debe ser en el pasado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}