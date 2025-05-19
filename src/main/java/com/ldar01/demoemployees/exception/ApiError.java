package com.ldar01.demoemployees.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ApiError {
    private Object message;
    private int status;
    private LocalDate time;
    private String uri;
}
