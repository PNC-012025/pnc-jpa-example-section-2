package com.ldar01.demoemployees.utils.mappers;

import com.ldar01.demoemployees.dto.request.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.EmployeeResponse;
import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeResponse employeeResponse) {
        return Employee.builder()
                .id(employeeResponse.getEmployeeId())
                .name(employeeResponse.getFirstName())
                .lastName(employeeResponse.getLastName())
                .email(employeeResponse.getEmail())
                .build();
    }

    public static Employee toEntityCreate(EmployeeRequest employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

    public static Employee toEntityUpdate(EmployeeUpdateRequest employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getEmployeeId())
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

    public static EmployeeResponse toDTO(Employee employee) {
        return EmployeeResponse.builder()
                .employeeId(employee.getId())
                .firstName(employee.getName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    public static List<EmployeeResponse> toDTOList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }
}
