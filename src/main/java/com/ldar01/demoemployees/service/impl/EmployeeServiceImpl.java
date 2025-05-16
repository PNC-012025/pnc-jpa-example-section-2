package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dto.request.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.EmployeeResponse;
import com.ldar01.demoemployees.repository.EmployeeRepository;
import com.ldar01.demoemployees.service.EmployeeService;
import com.ldar01.demoemployees.utils.mappers.EmployeeMapper;
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

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return EmployeeMapper.toDTOList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponse findById(int id) {
        return EmployeeMapper.toDTO(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employee) {
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntityCreate(employee)));
    }

    @Override
    public EmployeeResponse update(EmployeeUpdateRequest employee) {
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntityUpdate(employee)));
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
