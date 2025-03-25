package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.Person;
import com.deveclopers.rental_car.document.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  Person toEntity(PersonDto dto);

  PersonDto toDto(Person entity);
}
