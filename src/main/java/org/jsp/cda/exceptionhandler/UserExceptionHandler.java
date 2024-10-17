package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.InvalidCredentialsException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> invalidCredentialsExceptionHandler(InvalidCredentialsException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Invalid Credentials. Unable to verify").body(e.getMessage()).build());
	}

}
