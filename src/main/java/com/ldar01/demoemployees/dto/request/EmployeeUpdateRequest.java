package com.ldar01.demoemployees.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeUpdateRequest {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
