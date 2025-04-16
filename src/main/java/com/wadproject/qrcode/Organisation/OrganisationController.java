package com.wadproject.qrcode.Organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wadproject.qrcode.Employee.Employee;
import com.wadproject.qrcode.Employee.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all organisation's employees using Employee Repository
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Create a new organisation
    @PostMapping("/login")
    public ResponseEntity<Organisation> login(@RequestBody Organisation organisation) {
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return ResponseEntity.ok(savedOrganisation);
    }


    @PostMapping("/register")
    public ResponseEntity<Organisation> registerOrganisation(@RequestBody Organisation organisation) {
        Optional<Organisation> existingOrganisation = organisationRepository.findByEmail(organisation.getEmail());
        if (existingOrganisation.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return ResponseEntity.ok(savedOrganisation);
    }
}
