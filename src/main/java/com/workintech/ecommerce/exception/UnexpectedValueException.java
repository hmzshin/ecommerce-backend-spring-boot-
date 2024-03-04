package com.workintech.ecommerce.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class UnexpectedValueException extends RuntimeException {
    private HttpStatus status;

    public UnexpectedValueException(String message) {

        super(message);
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
