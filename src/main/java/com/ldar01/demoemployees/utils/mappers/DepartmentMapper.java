package com.ldar01.demoemployees.utils.mappers;

import com.ldar01.demoemployees.dto.request.department.DepartmentRequest;
import com.ldar01.demoemployees.dto.request.department.DepartmentUpdateRequest;
import com.ldar01.demoemployees.dto.response.department.DepartmentResponse;
import com.ldar01.demoemployees.entities.Department;

import java.util.List;

public class DepartmentMapper {
    public static Department toEntity(DepartmentResponse departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getDepartmentId())
                .departmentName(departmentDTO.getDepartmentName())
                .build();
    }

    public static Department toEntityCreate(DepartmentRequest departmentDTO) {
        return Department.builder()
                .departmentName(departmentDTO.getDepartmentName())
                .build();
    }

    public static Department toEntityUpdate(DepartmentUpdateRequest departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getDepartmentId())
                .departmentName(departmentDTO.getDepartmentName())
                .build();
    }

    public static DepartmentResponse toDTO(Department department) {
        return DepartmentResponse.builder()
                .departmentId(department.getId())
                .departmentName(department.getDepartmentName())
                .build();
    }

    public static List<DepartmentResponse> toDTOList(List<Department> departments) {
        return departments.stream()
                .map(DepartmentMapper::toDTO)
                .toList();
    }
}
