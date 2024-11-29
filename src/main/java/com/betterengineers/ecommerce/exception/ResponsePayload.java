package com.betterengineers.ecommerce.exception;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ResponsePayload<T> {

    private int statusCode;          // HTTP status code
    private LocalDateTime timestamp; // Time of the response
    private String uri;              // Request URI
    private String message;          // Additional context or success message
    private T data;                  // Data payload

    public static <T> ResponsePayload<T> create(int statusCode, String uri, String message, T data) {
        return ResponsePayload.<T>builder()
                .statusCode(statusCode)
                .timestamp(LocalDateTime.now())
                .uri(uri)
                .message(message)
                .data(data)
                .build();
    }
}

