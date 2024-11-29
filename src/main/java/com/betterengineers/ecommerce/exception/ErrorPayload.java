package com.betterengineers.ecommerce.exception;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ErrorPayload {

    private int statusCode;        // HTTP status code
    private String message;        // Error message
    private String details;        // Additional details (e.g., exception cause)
    private LocalDateTime timestamp; // Time of the error

    public static ErrorPayload create(int statusCode, String message, String details) {
        return ErrorPayload.builder()
                .statusCode(statusCode)
                .message(message)
                .details(details)
                .timestamp(LocalDateTime.now())
                .build();
    }
}

