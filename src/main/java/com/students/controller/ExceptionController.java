package com.students.controller;

import com.students.exception.StudentNotFoundException;
import com.students.dto.StudentExceptionDto;
import org.aspectj.bridge.IMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    private static final String ERROR = "exception.student.";

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentExceptionDto> handleRuntimeException(StudentNotFoundException exc) {
        return new ResponseEntity<>(new StudentExceptionDto(ERROR+exc.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StudentExceptionDto> handleRuntimeException() {
        return new ResponseEntity<>(new StudentExceptionDto(ERROR+"unexpected-error"), HttpStatus.valueOf(500));
    }
}
