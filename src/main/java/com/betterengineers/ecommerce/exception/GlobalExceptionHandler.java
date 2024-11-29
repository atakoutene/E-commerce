package com.betterengineers.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors (e.g., from @Valid).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorPayload> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();

        // Extract field-specific validation errors
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        // Build the error response payload
        ErrorPayload errorPayload = ErrorPayload.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("Validation error")
                .details("One or more fields have invalid values")
                .timestamp(LocalDateTime.now())
                .build();

        // Add field-specific validation messages in a map as part of the details
        errorPayload.setDetails(fieldErrors.toString());

        return new ResponseEntity<>(errorPayload, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles generic exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPayload> handleGenericException(Exception ex, WebRequest request) {
        ErrorPayload errorPayload = ErrorPayload.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred")
                .details(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorPayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

