package com.wadproject.qrcode.Organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    // Get all organisations
    @GetMapping
    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    // Create a new organisation
    @PostMapping
    public Organisation createOrganisation(@RequestBody Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    // Get organisation by ID
    @GetMapping("/{id}")
    public Organisation getOrganisationById(@PathVariable String id) {
        return organisationRepository.findById(id).orElse(null);
    }
}
