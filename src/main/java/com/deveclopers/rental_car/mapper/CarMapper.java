package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Car;
import com.deveclopers.rental_car.document.Category;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CarDto;
import com.deveclopers.rental_car.document.dto.CategoryDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  @Mapping(target = "name", source = "name", qualifiedByName = "toUpperCase")
  Brand dtoToEntity(BrandDto brandDto);

  Model dtoToEntity(ModelDto modelDto);

  Category dtoToEntity(CategoryDto categoryDto);

  @Mapping(target = "plate", source = "plate", qualifiedByName = "toUpperCase")
  Car dtoToEntity(CarDto carDto);

  @Named("toUpperCase")
  default String toUpperCase(String name) {
    return name != null ? name.toUpperCase() : null;
  }
}
