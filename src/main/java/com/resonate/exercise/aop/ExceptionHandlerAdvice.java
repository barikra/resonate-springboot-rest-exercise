package com.resonate.exercise.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.resonate.exercise.exception.BookAlreadyExistsException;
import com.resonate.exercise.exception.BookNotFoundException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundException(BookNotFoundException bookNotFoundException) {
		return new ResponseEntity<String>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BookAlreadyExistsException.class)
	public ResponseEntity<String> bookAlreadyExistsException(BookAlreadyExistsException alreadyExistsException) {
		return new ResponseEntity<String>(alreadyExistsException.getMessage(), HttpStatus.CONFLICT);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
	}
}
