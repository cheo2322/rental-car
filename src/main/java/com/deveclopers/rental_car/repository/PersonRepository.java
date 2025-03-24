package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

  Mono<Person> findByIdentification(String identification);
}
