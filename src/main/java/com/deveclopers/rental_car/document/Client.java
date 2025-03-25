package com.deveclopers.rental_car.document;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
@Getter
@Setter
public class Client {

  @Id private String id;
  @DocumentReference private DriverLicense driverLicense;
  private List<String> interests;
  @DocumentReference private Person person;
}
