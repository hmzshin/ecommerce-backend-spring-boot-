package com.workintech.ecommerce.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GlobalExceptionResponse {
    private String title;
    private HttpStatus status;
    private String message;
    private LocalDateTime createdAt;
}
