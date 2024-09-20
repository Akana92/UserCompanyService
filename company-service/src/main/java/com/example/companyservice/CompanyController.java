package com.example.companyservice;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        try {
            List<Company> companies = companyRepository.findAll();
            List<CompanyDTO> companyDTOs = new ArrayList<>();

            for (Company company : companies) {
                List<UserDTO> employees = new ArrayList<>();
                for (Long empId : company.getEmployeeIds()) {
                    try {
                        UserDTO user = userServiceClient.getUserById(empId);
                        employees.add(user);
                    } catch (Exception e) {
                        System.err.println("Ошибка при получении сотрудника с ID: " + empId + ". Сообщение: " + e.getMessage());
                    }
                }
                companyDTOs.add(new CompanyDTO(company, employees));
            }

            return ResponseEntity.ok(companyDTOs);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        Optional<Company> companyOpt = companyRepository.findById(id);
        if (!companyOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Company company = companyOpt.get();
        List<UserDTO> employees = new ArrayList<>();
        for (Long empId : company.getEmployeeIds()) {
            try {
                UserDTO user = userServiceClient.getUserById(empId);
                employees.add(user);
            } catch (Exception e) {

            }
        }
        CompanyDTO companyDTO = new CompanyDTO(company, employees);
        return ResponseEntity.ok(companyDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CompanyDTO> getCompanyByName(@PathVariable String name) {
        Optional<Company> companyOpt = companyRepository.findByNameIgnoreCase(name);
        if (!companyOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Company company = companyOpt.get();
        List<UserDTO> employees = new ArrayList<>();

        logger.info("Компания: {} (ID: {})", company.getName(), company.getId());

        for (Long empId : company.getEmployeeIds()) {
            try {
                UserDTO user = userServiceClient.getUserById(empId);
                employees.add(user);

                logger.info("Сотрудник: {} {} (ID: {})", user.getFirstName(), user.getLastName(), user.getIndividualNumber());
            } catch (Exception e) {
                logger.error("Ошибка при получении пользователя с ID: {}. Сообщение: {}", empId, e.getMessage());
            }
        }

        CompanyDTO companyDTO = new CompanyDTO(company, employees);
        return ResponseEntity.ok(companyDTO);
    }
}
