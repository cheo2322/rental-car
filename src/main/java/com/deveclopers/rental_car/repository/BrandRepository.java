package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Brand;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends ReactiveMongoRepository<Brand, String> {}
