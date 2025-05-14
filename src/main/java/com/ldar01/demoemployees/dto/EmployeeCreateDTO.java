package com.ldar01.demoemployees.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
}
