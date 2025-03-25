package com.deveclopers.rental_car.document;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Client {

  @Id private String id;
  private ObjectId driverLicenseId;
  private List<String> interests;
  private ObjectId personId;
}
