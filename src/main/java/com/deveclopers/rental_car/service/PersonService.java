package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.PersonDto;
import reactor.core.publisher.Mono;

/** CRUD and logic for Person documents */
public interface PersonService {

  /**
   * Create a Person when any related entity is created.
   *
   * @param personDto with Person data.
   * @return a Mono<Void> instance.
   */
  Mono<Void> createPerson(PersonDto personDto);
}
