package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Model;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ModelRepository extends ReactiveMongoRepository<Model, String> {

  Mono<Model> findByName(String name);
}
