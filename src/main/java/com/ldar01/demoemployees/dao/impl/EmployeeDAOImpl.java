package com.ldar01.demoemployees.dao.impl;

import com.ldar01.demoemployees.dao.EmployeeDAO;
import com.ldar01.demoemployees.entities.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager em;

    @Override
    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
