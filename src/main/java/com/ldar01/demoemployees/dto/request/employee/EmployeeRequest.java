package com.ldar01.demoemployees.dto.request.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid with @")
    private String email;

    @NotBlank(message = "You must enter a valid department name")
    private String department;
}
