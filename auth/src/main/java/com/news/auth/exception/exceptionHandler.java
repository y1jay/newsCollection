package com.news.auth.exception;

import com.news.auth.responses.commonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class exceptionHandler {
    commonResponse res = new commonResponse();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public commonResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            res.setCode(400);
            res.setMessage(errors.toString());
        }
        res.setCode(200);
        res.setMessage("Success");

        return res;
    }
}
