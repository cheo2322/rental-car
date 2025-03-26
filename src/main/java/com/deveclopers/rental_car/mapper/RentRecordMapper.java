package com.deveclopers.rental_car.mapper;

import com.deveclopers.rental_car.document.RentRecord;
import com.deveclopers.rental_car.document.dto.RentRecordDto;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentRecordMapper {

  RentRecordMapper INSTANCE = Mappers.getMapper(RentRecordMapper.class);

  @Mapping(target = "carId", source = "carId", qualifiedByName = "stringToObjectId")
  @Mapping(target = "clientId", source = "clientId", qualifiedByName = "stringToObjectId")
  @Mapping(
      target = "responsibleAgentEmployeeId",
      source = "responsibleAgentEmployeeId",
      qualifiedByName = "stringToObjectId")
  @Mapping(
      target = "responsibleManagerEmployeeId",
      source = "responsibleManagerEmployeeId",
      qualifiedByName = "stringToObjectId")
  @Mapping(
      target = "responsibleOfficeId",
      source = "responsibleOfficeId",
      qualifiedByName = "stringToObjectId")
  @Mapping(
      target = "driverEmployeeId",
      source = "driverEmployeeId",
      qualifiedByName = "stringToObjectId")
  RentRecord dtoToRecord(RentRecordDto rentRecordDto);

  @Named("stringToObjectId")
  default ObjectId stringToObjectId(String id) {
    return StringUtils.isBlank(id) ? null : new ObjectId(id);
  }
}
