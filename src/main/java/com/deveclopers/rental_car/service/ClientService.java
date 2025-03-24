package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.ClientDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import reactor.core.publisher.Mono;

/** Service for CRUD Client document. */
public interface ClientService {

  Mono<ClientDto> createClient(PersonDto personDto);
}
