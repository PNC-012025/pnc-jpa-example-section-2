package com.ldar01.demoemployees.utils.mappers;

import com.ldar01.demoemployees.dto.request.employee.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.employee.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.employee.EmployeeResponse;
import com.ldar01.demoemployees.entities.Department;
import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

public class EmployeeMapper {

    public static Employee toEntityCreate(EmployeeRequest employeeDTO, Department department) {
        return Employee.builder()
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .department(department)
                .build();
    }

    public static Employee toEntityUpdate(EmployeeUpdateRequest employeeDTO, Department department) {
        return Employee.builder()
                .id(employeeDTO.getEmployeeId())
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .department(department)
                .build();
    }

    public static EmployeeResponse toDTO(Employee employee) {
        return EmployeeResponse.builder()
                .employeeId(employee.getId())
                .firstName(employee.getName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .department(employee.getDepartment().getDepartmentName())
                .build();
    }

    public static List<EmployeeResponse> toDTOList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }
}
