package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.Person;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import reactor.core.publisher.Mono;

/** CRUD and logic for Person documents */
public interface PersonService {

  /**
   * Create a {@link Person} when any related entity is created.
   *
   * @param personDto with Person data.
   * @return a Mono<Void> instance.
   */
  Mono<Void> createPerson(PersonDto personDto);

  /**
   * Get a {@link Person} if exists.
   *
   * @param personIdentification from Person to get.
   * @return a DefaultDto with the Person ID in case it exists, handles 404 otherwise.
   */
  Mono<DefaultDto> getPerson(String personIdentification);
}
