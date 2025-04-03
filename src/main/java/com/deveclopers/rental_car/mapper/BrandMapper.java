package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {

  BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

  IdAndNameDto instanceToDto(Brand brand);
}
