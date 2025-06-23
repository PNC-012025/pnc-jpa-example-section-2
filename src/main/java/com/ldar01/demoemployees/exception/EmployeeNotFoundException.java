package com.ldar01.demoemployees.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException() {}

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
