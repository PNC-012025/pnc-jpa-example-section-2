package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api") //Don´t forget to add this annotation for the controller and redirection
public class EmployeeController {
    // This is the service that will be used to handle the business logic
    private final EmployeeService employeeService;

    // Constructor injection is preferred over field injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // This is the endpoint that will be used to get all employees
    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/test")
    public String test() {
        return "Test ;v";
    }
}
