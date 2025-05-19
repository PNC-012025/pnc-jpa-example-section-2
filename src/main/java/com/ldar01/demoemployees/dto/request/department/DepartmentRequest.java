package com.ldar01.demoemployees.dto.request.department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentRequest {
    @NotNull(message = "Department name cannot be null")
    @NotBlank(message = "Department name cannot be empty")
    private String departmentName;
}
