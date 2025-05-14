package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.EmployeeCreateDTO;
import com.ldar01.demoemployees.dto.EmployeeDTO;
import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

/**
 * EmployeeService is the interface for the Employee Service.
 * It defines the methods to interact with the Employee data.
 */
public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(int id);
    EmployeeDTO save(EmployeeCreateDTO employee);
    EmployeeDTO update(EmployeeDTO employee);
    void delete(int id);
}
