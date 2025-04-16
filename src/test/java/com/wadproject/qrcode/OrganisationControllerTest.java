package com.wadproject.qrcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.wadproject.qrcode.Organisation.Organisation;
import com.wadproject.qrcode.Organisation.OrganisationRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrganisationControllerTest {

    private final String BASE_URL = "http://localhost:8080/organisation";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrganisationRepository organisationRepository;

    // idk hwat this part does, blindly relying on chatgpt for this test part 

    @BeforeEach
    public void setup() {
        organisationRepository.deleteAll(); // Clear existing data
        Organisation organisation = new Organisation();
        organisation.setEmail("test@example.com");
        organisation.setPassword("password123");
        organisationRepository.save(organisation); // Seed test data
    }

    /*  ???
    @Test
    public void testGetAllEmployees() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/employees", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    */

    @Test
    public void testCreateOrganisation() {
        // Updated test to include organisation ID, password, and email
        Organisation organisation = new Organisation();
        organisation.setEmail("test@example.com");
        organisation.setPassword("password123");

        // Updated to expect a String response instead of Organisation
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/login", organisation, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login successful", response.getBody());
    }

    @Test
    public void testLogin() {
        Organisation organisation = new Organisation();
        organisation.setEmail("test@example.com");
        organisation.setPassword("password123");

        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/login", organisation, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login successful", response.getBody());
    }
}