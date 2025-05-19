package com.ldar01.demoemployees.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeUpdateRequest {
    @NotNull(message = "You must provide an employee ID")
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
