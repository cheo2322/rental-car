package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.DriverLicense;
import com.deveclopers.rental_car.document.dto.LicenseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LicenseMapper {

  LicenseMapper INSTANCE = Mappers.getMapper(LicenseMapper.class);

  DriverLicense dtoToEntity(LicenseDto licenseDto);
}
