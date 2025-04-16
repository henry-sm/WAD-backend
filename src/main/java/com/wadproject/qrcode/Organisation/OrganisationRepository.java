package com.wadproject.qrcode.Organisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation, String> {
    Optional<Organisation> findByEmail(String email);
}
