package com.spring.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyStringValidator implements ConstraintValidator<CustomEmptyAnnotation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 return value != null && !value.trim().isEmpty();
	}

	@Override
	public void initialize(CustomEmptyAnnotation constraintAnnotation) {
		
	}

}
