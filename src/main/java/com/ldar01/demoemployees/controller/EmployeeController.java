package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/test")
    public String test() {
        return "Test ;v";
    }
}
