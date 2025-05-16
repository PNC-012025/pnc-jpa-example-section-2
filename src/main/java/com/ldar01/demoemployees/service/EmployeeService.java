package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.EmployeeResponse;

import java.util.List;

/**
 * EmployeeService is the interface for the Employee Service.
 * It defines the methods to interact with the Employee data.
 */
public interface EmployeeService {
    List<EmployeeResponse> findAll();
    EmployeeResponse findById(int id);
    EmployeeResponse save(EmployeeRequest employee);
    EmployeeResponse update(EmployeeUpdateRequest employee);
    void delete(int id);
}
