package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Model;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends ReactiveMongoRepository<Model, String> {}
