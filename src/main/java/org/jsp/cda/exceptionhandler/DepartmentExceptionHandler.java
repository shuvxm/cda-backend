package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.InvalidDepartmentIdException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler {

    @ExceptionHandler(InvalidDepartmentIdException.class)
    public ResponseEntity<?> invalidDepartmentIdExceptionHandler(InvalidDepartmentIdException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid Id. Unable to delete").body(e.getMessage()).build());
    }
}
