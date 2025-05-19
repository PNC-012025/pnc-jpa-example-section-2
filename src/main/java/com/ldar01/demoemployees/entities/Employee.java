package com.ldar01.demoemployees.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Employee is the entity class for the employees table in the database.
 * It uses JPA annotations to map the class to the table.
 */
@Entity
@Table(name = "employees")
//@Getter
//@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
