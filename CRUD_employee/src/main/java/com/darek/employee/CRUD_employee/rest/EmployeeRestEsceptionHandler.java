package com.darek.employee.CRUD_employee.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestEsceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlerException(EmployeeNotFoundException e) {

        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    //zamiast tego jest lepszy sposób obsługi wyjątków - @ControllerAdvice
    //generic handler exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception e) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
