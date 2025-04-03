package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

  ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

  IdAndNameDto instanceToDto(Model model);
}
