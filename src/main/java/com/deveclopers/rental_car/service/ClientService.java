package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.Client;
import com.deveclopers.rental_car.document.Person;
import com.deveclopers.rental_car.document.dto.ClientDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import reactor.core.publisher.Mono;

/** Service for CRUD Client document. */
public interface ClientService {

  /**
   * Create a new {@link Person} (if needed) and {@link Client} documents.
   *
   * @param personDto with Client data.
   * @return A ClientDto with the Client ID.
   */
  Mono<ClientDto> createClient(PersonDto personDto);

  /**
   * Get the {@link Person} document in case it exists.
   *
   * @param personIdentification the Person identification.
   * @return the ClientDto in case it exists, 404 otherwise.
   */
  Mono<ClientDto> getClient(String personIdentification);
}
