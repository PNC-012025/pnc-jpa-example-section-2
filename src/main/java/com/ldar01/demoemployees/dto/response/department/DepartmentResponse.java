package com.ldar01.demoemployees.dto.response.department;

import com.ldar01.demoemployees.entities.Department;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {
    private Integer departmentId;
    private String departmentName;
}
