package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/employee") //Don´t forget to add this annotation for the controller and redirection
public class EmployeeController {
    // This is the service that will be used to handle the business logic
    private final EmployeeService employeeService;

    // Constructor injection is preferred over field injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // This is the endpoint that will be used to get all employees
    @GetMapping()
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }
/*
    @GetMapping()
    public Employee getEmployeeById(@RequestParam int id) {
        return employeeService.findById(id);
    }
*/
    @GetMapping("/{id}")
    public Employee getEmployeeById2(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Test ;v";
    }
}
