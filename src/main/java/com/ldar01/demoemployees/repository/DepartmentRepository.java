package com.ldar01.demoemployees.repository;

import com.ldar01.demoemployees.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);
    boolean existsDepartmentByDepartmentName(String departmentName);
}
