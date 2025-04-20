package com.wadproject.qrcode.Employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    boolean existsByEmail(String email);
    List<Employee> findByOrganisationId(String organisationId);
}
