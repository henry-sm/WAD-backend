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
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable String id) {
        return employeeRepository.findByOrganisationId(id);
    }

    @GetMapping
    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }


    // Create a new organisation
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Organisation organisation) {
        Optional<Organisation> existingOrganisation = organisationRepository.findByEmail(organisation.getEmail());
        if (existingOrganisation.isPresent()) {
            Organisation storedOrganisation = existingOrganisation.get();
            if (storedOrganisation.getPassword().equals(organisation.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(storedOrganisation);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organisation not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        if (!organisationRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<Employee> employees = employeeRepository.findByOrganisationId(id);;
        if(employees.size() != 0){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        organisationRepository.deleteById(id);
        return ResponseEntity.ok().build();
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
