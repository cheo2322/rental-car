package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.dto.BrandDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  Brand dtoToEntity(BrandDto brandDto);
}
