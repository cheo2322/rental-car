package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Person;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.PersonDto;
import com.deveclopers.rental_car.mapper.PersonMapper;
import com.deveclopers.rental_car.repository.PersonRepository;
import com.deveclopers.rental_car.service.PersonService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  private static final PersonMapper personMapper = PersonMapper.INSTANCE;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Mono<Void> createPerson(PersonDto personDto) {
    Person entity = personMapper.toEntity(personDto);
    return personRepository.save(entity).then();
  }

  @Override
  public Mono<DefaultDto> getPerson(String personIdentification) {
    return personRepository
        .findByIdentification(personIdentification)
        .map(person -> new DefaultDto(person.getId()))
        .switchIfEmpty(Mono.error(new RuntimeException("Person not found.")));
  }
}
