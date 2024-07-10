package com.Electronics.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchBrandException.class)
	public ResponseEntity<Object> displayThis(NoSuchBrandException be) {
		return new ResponseEntity<>("Error Occurs",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> displayThis1(NullPointerException ne) {
		return new ResponseEntity<Object>("Error Occurs",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> displayThis2(NoSuchElementException nse) {
		return new ResponseEntity<Object>("Error Occurs",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PriceException.class)
	public ResponseEntity<Object> displayThis3(PriceException pe) {
		return new ResponseEntity<Object>("Price Range is High",HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	

}
