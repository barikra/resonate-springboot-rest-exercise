package com.resonate.exercise.validator;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = IsinValidator.class)
@Target({ ElementType.METHOD, CONSTRUCTOR, PARAMETER,ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsinAlphanumeric {
	String message() default "Required Alphanumeric";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
