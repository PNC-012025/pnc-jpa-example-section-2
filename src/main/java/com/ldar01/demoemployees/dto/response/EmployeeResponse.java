package com.ldar01.demoemployees.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
