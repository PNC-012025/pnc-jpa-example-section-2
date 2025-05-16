package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.dto.request.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.EmployeeResponse;
import com.ldar01.demoemployees.exception.ApiError;
import com.ldar01.demoemployees.exception.EmployeeNotFoundException;
import com.ldar01.demoemployees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<List<EmployeeResponse>> getEmployee() {
        List<EmployeeResponse> employees = employeeService.findAll();

        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("Employees not found or empty list");
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        EmployeeResponse employee = employeeService.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody @Valid EmployeeRequest employee) {
        if (employee == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeUpdateRequest employee) {
        EmployeeResponse updatedEmployee = employeeService.findById(employee.getEmployeeId());
        if (updatedEmployee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }
}
