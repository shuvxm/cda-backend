package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.NoStudentFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<?> noStudentFoundExceptionHandler(NoStudentFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No such Student found in db.").body(e.getMessage()).build());
    }
}
