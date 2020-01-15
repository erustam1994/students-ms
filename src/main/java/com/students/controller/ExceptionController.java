package com.students.controller;

import com.students.exception.NotFoundException;
import com.students.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    private static final String ERROR = "exception.";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleStudentNotFoundException(NotFoundException exc) {
        System.out.println(exc.getMessage());
        return new ResponseEntity<>(new ExceptionDto(ERROR+exc.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException exc) {
        System.out.println(exc.getMessage());
        return new ResponseEntity<>(new ExceptionDto(ERROR+"unexpected-error"), HttpStatus.valueOf(500));
    }
}
