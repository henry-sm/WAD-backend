package com.wadproject.qrcode.Organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wadproject.qrcode.Employee.Employee;
import com.wadproject.qrcode.Employee.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all organisation's employees using Employee Repository 
    @GetMapping("/employees")
    public List<Organisation> getAllEmployees() {
        return null;
    }

    // Create a new organisation
    @PostMapping("/login")
    public ResponseBody createOrganisation(@PathVariable String password) {
        //verify password here
        return null;
    }
}
