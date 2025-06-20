package com.ldar01.demoemployees;

import com.ldar01.demoemployees.entities.Department;
import com.ldar01.demoemployees.entities.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EmployeeTest {
    @Test
    public void testEmployee(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setDepartment(Department.builder().build());
        employee.setName("Juan");
        employee.setLastName("Doe");
        employee.setEmail("luisa@gmail.com");

        assertNotNull(employee.getRoles());
    }
}
