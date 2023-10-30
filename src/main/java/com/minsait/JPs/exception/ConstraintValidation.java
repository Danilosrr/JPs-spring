package com.minsait.JPs.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ConstraintValidation {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getAllErrors();
        String resposta = "";
        for (int i = 0; i < errors.size(); i++) {
            resposta += errors.get(i).getDefaultMessage() + ", ";
        }

        return ResponseEntity.unprocessableEntity().body(resposta);
    };
}
