package com.students.exception;

public class StudentException extends RuntimeException {

    public StudentException() {
    }

    public StudentException(String message) {
        super(message);
    }
}
