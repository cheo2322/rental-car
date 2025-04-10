package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

  Mono<Category> findByName(String name);
}
