package com.ldar01.demoemployees.repository;

import com.ldar01.demoemployees.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsernameOrEmail(String username, String email);
}
