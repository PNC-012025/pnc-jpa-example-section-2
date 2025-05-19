package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.department.DepartmentRequest;
import com.ldar01.demoemployees.dto.request.department.DepartmentUpdateRequest;
import com.ldar01.demoemployees.dto.response.department.DepartmentResponse;

import java.util.List;
/**
 * DepartmentService is the interface for the Department Service.
 * It defines the methods to interact with the Department data.
 */
public interface DepartmentService {
    List<DepartmentResponse> findAll();
    DepartmentResponse findById(int id);
    boolean doesDepartmentExist(String name);
    DepartmentResponse save(DepartmentRequest employee);
    DepartmentResponse update(DepartmentUpdateRequest employee);
    void delete(int id);
}
