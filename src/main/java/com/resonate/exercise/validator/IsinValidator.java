package com.resonate.exercise.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsinValidator implements ConstraintValidator<IsinAlphanumeric, String> {
	@Override
	public boolean isValid(String isin, ConstraintValidatorContext cxt) {
		return isin != null && !isin.matches("[0-9]+") && !isin.matches("^[a-zA-Z]*$");
	}
}
