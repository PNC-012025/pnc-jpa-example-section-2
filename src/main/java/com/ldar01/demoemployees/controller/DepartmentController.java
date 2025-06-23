package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.dto.request.department.DepartmentRequest;
import com.ldar01.demoemployees.dto.request.department.DepartmentUpdateRequest;
import com.ldar01.demoemployees.dto.response.department.DepartmentResponse;
import com.ldar01.demoemployees.dto.response.GeneralResponse;
import com.ldar01.demoemployees.exception.DepartmentNotFoundException;
import com.ldar01.demoemployees.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<GeneralResponse> getAllDepartments() {
        List<DepartmentResponse> departments = departmentService.findAll();

        if (departments.isEmpty()) {
            throw new DepartmentNotFoundException("Departments were not found");
        }
        return buildResponse("Departments found", HttpStatus.OK, departments);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<GeneralResponse> getDepartmentById(@PathVariable int id) {
        DepartmentResponse department = departmentService.findById(id);
        return buildResponse("Department found", HttpStatus.OK, department);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GeneralResponse> saveDepartment(@RequestBody @Valid DepartmentRequest department) {

        return buildResponse("Department created", HttpStatus.CREATED, departmentService.save(department));
    }

    @PutMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GeneralResponse> updateDepartment(@RequestBody @Valid DepartmentUpdateRequest department) {
        departmentService.findById(department.getDepartmentId());
        return buildResponse("Department updated", HttpStatus.OK, departmentService.update(department));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GeneralResponse> deletDepartment(@PathVariable int id) {
        DepartmentResponse department = departmentService.findById(id);
        departmentService.delete(id);
        return buildResponse("Department deleted", HttpStatus.OK, department);
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity.status(status).body(GeneralResponse.builder()
                .message(message)
                .status(status.value())
                .data(data)
                .uri(uri)
                .time(LocalDate.now())
                .build());
    }
}
