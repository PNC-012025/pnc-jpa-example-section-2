package com.ldar01.demoemployees.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid with @")
    private String email;
}
