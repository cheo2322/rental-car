package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Client;
import com.deveclopers.rental_car.document.dto.ClientDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import com.deveclopers.rental_car.mapper.PersonMapper;
import com.deveclopers.rental_car.repository.ClientRepository;
import com.deveclopers.rental_car.repository.PersonRepository;
import com.deveclopers.rental_car.service.ClientService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

  private final PersonRepository personRepository;
  private final ClientRepository clientRepository;

  private static final PersonMapper personMapper = PersonMapper.INSTANCE;

  public ClientServiceImpl(PersonRepository personRepository, ClientRepository clientRepository) {
    this.personRepository = personRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public Mono<ClientDto> createClient(PersonDto personDto) {
    return personRepository
        .findByIdentification(personDto.identification())
        .flatMap(
            personDB -> {
              // TODO: Update in case needed
              return personRepository.save(personDB);
            })
        .switchIfEmpty(Mono.defer(() -> personRepository.save(personMapper.toEntity(personDto))))
        .flatMap(
            person -> {
              Client client = new Client();
              client.setPerson(person);

              return clientRepository.save(client);
            })
        .map(client -> new ClientDto(client.getId()));
  }
}
