package com.example.companyservice;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CompanyDTO {
    private Long id;
    private String name;
    private Double budget;
    private List<UserDTO> employees;

    public CompanyDTO() {}

    public CompanyDTO(Company company, List<UserDTO> employees) {
        this.id = company.getId();
        this.name = company.getName();
        this.budget = company.getBudget();
        this.employees = employees;
    }
}
