package com.ldar01.demoemployees.dto.request.department;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentUpdateRequest {
    @NotNull(message = "You must provide an department ID")
    private Integer departmentId;
    private String departmentName;
}
