package com.example.usercrud.controller;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

import static com.example.usercrud.Constants.*;

@ControllerAdvice
@Slf4j
public class ControllerGlobalException {


    // Validation exception handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    private Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.error(errors.toString());
        return errors;
    }

    // Wrong format exception handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    private String handleMismatchExceptions() {
        return BAD_TYPE;
    }

    // Type mismatch exception handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    private String handleMethodArgumentTypeMismatchException() {
        return BAD_TYPE;
    }

    // Request not supported exception handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    private String handleNotSupportedRequest() {
        return BAD_METHOD;
    }

    // Data integrity violation - constraints, ...
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    private String handleDataIntegrityViolationException() {
        return DATA_INTEGRITY_VIOLATION;
    }

    // Data integrity violation - constraints, ...
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    private String handleConstraintViolationException() {
        return DATA_CONSTRAINT_VIOLATION;
    }

    // Data integrity violation - bad join
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    @ResponseBody
    private String handleJpaObjectRetrievalFailureException() {
        return DATA_CONSTRAINT_VIOLATION;
    }


    // Data integrity violation - bad join
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseBody
    private String handleInvalidDataAccessApiUsageException() {
        return DATA_CONSTRAINT_VIOLATION;
    }
}
