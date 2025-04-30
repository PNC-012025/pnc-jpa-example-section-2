package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

/**
 * EmployeeService is the interface for the Employee Service.
 * It defines the methods to interact with the Employee data.
 */
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
