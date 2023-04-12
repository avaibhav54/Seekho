package com.seekho.seekho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SeekhoException.class)
    public ResponseEntity<?> invalidCouponExceptionHandler(SeekhoException ex){
        String fieldName = ex.getFieldName();
        String message = ex.getErrorMessage();
        return new ResponseEntity(message, HttpStatus.NOT_ACCEPTABLE);
    }
}
