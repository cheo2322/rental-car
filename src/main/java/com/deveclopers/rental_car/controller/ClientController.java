package com.deveclopers.rental_car.controller;

import com.deveclopers.rental_car.document.dto.ClientDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import com.deveclopers.rental_car.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rental-car/v1/clients")
public class ClientController {

  public final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public Mono<ResponseEntity> createClient(@RequestBody PersonDto personDto) {
    return clientService
        .createClient(personDto)
        .map(clientDto -> ResponseEntity.status(HttpStatus.CREATED).body(clientDto));
  }

  @GetMapping("/{identification}")
  public Mono<ResponseEntity<ClientDto>> getClient(
      @PathVariable("identification") String personIdentification) {
    return clientService
        .getClient(personIdentification)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
