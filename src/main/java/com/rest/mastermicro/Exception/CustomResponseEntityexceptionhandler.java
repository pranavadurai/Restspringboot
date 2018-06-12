package com.rest.mastermicro.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityexceptionhandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webreq ){
		  
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(), webreq.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webreq ){
		  
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(), webreq.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionresponse, HttpStatus.NOT_FOUND);
	}
	
}
