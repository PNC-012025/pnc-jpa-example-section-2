package com.ldar01.demoemployees.dao;

import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

/**
 * EmployeeDAO is the interface for the Employee Data Access Object.
 * It defines the methods to interact with the database.
 */
public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
