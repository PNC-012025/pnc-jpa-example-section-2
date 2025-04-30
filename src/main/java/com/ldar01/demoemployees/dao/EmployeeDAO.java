package com.ldar01.demoemployees.dao;

import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
