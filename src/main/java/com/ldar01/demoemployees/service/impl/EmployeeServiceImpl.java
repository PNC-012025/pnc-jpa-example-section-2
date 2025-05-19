package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dto.request.employee.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.employee.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.department.DepartmentResponse;
import com.ldar01.demoemployees.dto.response.employee.EmployeeResponse;
import com.ldar01.demoemployees.entities.Department;
import com.ldar01.demoemployees.exception.DepartmentNotFoundException;
import com.ldar01.demoemployees.exception.EmployeeNotFoundException;
import com.ldar01.demoemployees.repository.DepartmentRepository;
import com.ldar01.demoemployees.repository.EmployeeRepository;
import com.ldar01.demoemployees.service.DepartmentService;
import com.ldar01.demoemployees.service.EmployeeService;
import com.ldar01.demoemployees.utils.mappers.DepartmentMapper;
import com.ldar01.demoemployees.utils.mappers.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmployeeServiceImpl is the implementation of the EmployeeService interface.
 * It uses the EmployeeDAO to interact with the database.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, DepartmentService departmentService) {
        this.employeeRepository = repository;
        this.departmentService = departmentService;
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return EmployeeMapper.toDTOList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponse findById(int id) {
        return EmployeeMapper.toDTO(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found")));
    }

    @Override
    @Transactional
    public EmployeeResponse save(EmployeeRequest employee) {
        DepartmentResponse department = departmentService.findByName(employee.getDepartment());
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntityCreate(employee, DepartmentMapper.toEntity(department))));
    }

    @Override
    @Transactional
    public EmployeeResponse update(EmployeeUpdateRequest employee) {
        DepartmentResponse department = departmentService.findByName(employee.getDepartment());
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntityUpdate(employee, DepartmentMapper.toEntity(department))));
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
