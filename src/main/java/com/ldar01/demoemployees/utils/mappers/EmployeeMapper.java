package com.ldar01.demoemployees.utils.mappers;

import com.ldar01.demoemployees.dto.EmployeeCreateDTO;
import com.ldar01.demoemployees.dto.EmployeeDTO;
import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getEmployeeId())
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

    public static Employee toEntityCreate(EmployeeCreateDTO employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

    public static EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeId(employee.getId())
                .firstName(employee.getName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    public static List<EmployeeDTO> toDTOList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }
}
