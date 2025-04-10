package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

  Mono<Client> findByPersonId(ObjectId personId);
}
