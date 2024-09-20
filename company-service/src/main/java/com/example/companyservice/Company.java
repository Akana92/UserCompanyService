package com.example.companyservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double budget;

    @ElementCollection
    private List<Long> employeeIds;

    public Company() {}

    public Company(String name, Double budget, List<Long> employeeIds) {
        this.name = name;
        this.budget = budget;
        this.employeeIds = employeeIds;
    }
}
