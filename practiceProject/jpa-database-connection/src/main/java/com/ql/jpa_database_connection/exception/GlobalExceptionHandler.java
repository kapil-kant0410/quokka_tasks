package com.ql.jpa_database_connection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleAllExceptions(Exception ex){
           ex.printStackTrace();
         return ResponseEntity.ok("please pass the valid email and name.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<?> MethodArgumentTypeMismatchException(Exception ex){
        return ResponseEntity.badRequest().body("Please provide valid path variables id as integer.");
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    ResponseEntity<?> HandleMethodValidationException(Exception ex){
        return ResponseEntity.badRequest().body("Please provide valid path variables id as integer.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
         Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
             return ResponseEntity.badRequest().body(errors);
    }



}
