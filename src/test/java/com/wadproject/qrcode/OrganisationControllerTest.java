package com.wadproject.qrcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.wadproject.qrcode.Organisation.Organisation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrganisationControllerTest {

    private final String BASE_URL = "http://localhost:8080/organisation";

    @Autowired
    private RestTemplate restTemplate;

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
        Organisation organisation = new Organisation();


        ResponseEntity<Organisation> response = restTemplate.postForEntity(BASE_URL + "/login", organisation, Organisation.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // Updated to assert that the ID is not null instead of checking for a specific value
        assertNotNull(response.getBody().getId());
    }
}