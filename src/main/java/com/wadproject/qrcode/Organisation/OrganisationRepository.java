package com.wadproject.qrcode.Organisation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation, String> {
    // You can add custom methods here later
}
