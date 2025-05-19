package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dto.request.department.DepartmentRequest;
import com.ldar01.demoemployees.dto.request.department.DepartmentUpdateRequest;
import com.ldar01.demoemployees.dto.response.department.DepartmentResponse;
import com.ldar01.demoemployees.exception.DepartmentNotFoundException;
import com.ldar01.demoemployees.repository.DepartmentRepository;
import com.ldar01.demoemployees.service.DepartmentService;
import com.ldar01.demoemployees.utils.mappers.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.departmentRepository = repository;
    }

    @Override
    public List<DepartmentResponse> findAll() {
        return DepartmentMapper.toDTOList(departmentRepository.findAll());
    }

    @Override
    public DepartmentResponse findById(int id) {
        return DepartmentMapper.toDTO(departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found")));
    }

    @Override
    public boolean doesDepartmentExist(String name) {
        return departmentRepository.existsDepartmentByDepartmentName(name.toUpperCase());
    }

    @Override
    public DepartmentResponse save(DepartmentRequest department) {
        department.setDepartmentName(department.getDepartmentName().toUpperCase());
        return DepartmentMapper.toDTO(departmentRepository.save(DepartmentMapper.toEntityCreate(department)));
    }

    @Override
    public DepartmentResponse update(DepartmentUpdateRequest department) {
        department.setDepartmentName(department.getDepartmentName().toUpperCase());
        return DepartmentMapper.toDTO(departmentRepository.save(DepartmentMapper.toEntityUpdate(department)));
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }
}
