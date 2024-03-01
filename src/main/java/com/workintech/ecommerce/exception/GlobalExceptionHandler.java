package com.workintech.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("null")
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<GlobalExceptionResponse> handleValidationException(ValidationException validationException) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(
                "Occurred because one of the field information you sended is not valid.",
                validationException.getStatus(),
                validationException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, validationException.getStatus());
    }

    @SuppressWarnings("null")
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<GlobalExceptionResponse> handleConflictException(ConflictException conflictException) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(
                "Occurred because the in formation sended is not consistent.",
                conflictException.getStatus(),
                conflictException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, conflictException.getStatus());
    }

    @SuppressWarnings("null")
    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<GlobalExceptionResponse> handleNotExistException(NotExistException notExistException) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(
                "Not exist",
                notExistException.getStatus(),
                notExistException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, notExistException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<GlobalExceptionResponse> exceptionHandler(Exception exception) {
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(
                "Occurred because you made a unexpected request.",
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}