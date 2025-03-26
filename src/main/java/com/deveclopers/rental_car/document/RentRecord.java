package com.deveclopers.rental_car.document;

import com.deveclopers.rental_car.document.enums.RentType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class RentRecord {

  @Id private String id;
  private ObjectId carId;
  private ObjectId clientId;
  private ObjectId responsibleAgentEmployeeId;
  private ObjectId responsibleManagerEmployeeId;
  private ObjectId responsibleOfficeId;
  private LocalDateTime rentDate = LocalDateTime.now();
  private LocalDateTime start;
  private LocalDateTime end;
  private Boolean withDriver;
  private ObjectId driverEmployeeId;
  private Double totalToPay;
  private Boolean isPickedUpAtOffice;
  private String externalPlaceToPickUp;
  private String coordinatesToPickup;
  private Boolean isReturnedToOffice;
  private String externalPlaceToRetrieve;
  private String coordinatesToRetrieve;
  private RentType type;
  private Integer daysRent;
  private Integer hoursRent;
  private String invoiceNumber;
}
