package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends ReactiveMongoRepository<Car, String> {

  Mono<Car> findByPlate(String plate);
}
