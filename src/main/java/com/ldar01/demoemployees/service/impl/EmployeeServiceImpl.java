package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dao.EmployeeDAO;
import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmployeeServiceImpl is the implementation of the EmployeeService interface.
 * It uses the EmployeeDAO to interact with the database.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
