package com.ldar01.demoemployees.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "departments", schema = "public")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;
}
