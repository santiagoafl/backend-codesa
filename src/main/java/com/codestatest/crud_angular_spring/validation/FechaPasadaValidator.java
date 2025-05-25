package com.codestatest.crud_angular_spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class FechaPasadaValidator implements ConstraintValidator<FechaPasada, LocalDate> {

    @Override
    public boolean isValid(LocalDate fecha, ConstraintValidatorContext context) {
        return fecha != null && fecha.isBefore(LocalDate.now());
    }
}