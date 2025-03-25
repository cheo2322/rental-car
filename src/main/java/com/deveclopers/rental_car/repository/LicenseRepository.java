package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.DriverLicense;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends ReactiveMongoRepository<DriverLicense, String> {}
