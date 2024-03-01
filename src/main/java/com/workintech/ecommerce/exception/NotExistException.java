package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotExistException extends RuntimeException {

    private HttpStatus status;

    public NotExistException(String field, Long id) {
        super(field + " with given id: " + id + " is not exist.");
        this.status = HttpStatus.NOT_FOUND;
    }
}
