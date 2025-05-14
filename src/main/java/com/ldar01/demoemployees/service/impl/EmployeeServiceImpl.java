package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dto.EmployeeCreateDTO;
import com.ldar01.demoemployees.dto.EmployeeDTO;
import com.ldar01.demoemployees.entities.Employee;
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
    public List<EmployeeDTO> findAll() {
        return EmployeeMapper.toDTOList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findById(int id) {
        return EmployeeMapper.toDTO(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDTO save(EmployeeCreateDTO employee) {
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntityCreate(employee)));
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employee) {
        return EmployeeMapper.toDTO(employeeRepository.save(EmployeeMapper.toEntity(employee)));
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
