package org.jsp.cda.exceptionhandler;


import org.jsp.cda.exceptionclasses.InvalidEnrollmentIdFoundException;
import org.jsp.cda.exceptionclasses.NoEnrollmentFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EnrollmentExceptionHandler {

    @ExceptionHandler(NoEnrollmentFoundException.class)
    public ResponseEntity<?> noEnrollmentFoundExceptionHandler(NoEnrollmentFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No enrollment found with this id in db.").body(e.getMessage()).build());
    }

    @ExceptionHandler(InvalidEnrollmentIdFoundException.class)
    public ResponseEntity<?> invalidEnrollmentIdFoundExceptionHandler(InvalidEnrollmentIdFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No any enrollment found in db.").body(e.getMessage()).build());
    }

}
