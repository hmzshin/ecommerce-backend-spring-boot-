package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException {

    private HttpStatus status;

    public ValidationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
