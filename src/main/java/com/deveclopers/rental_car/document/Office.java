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
public class Office {

  @Id private String id;
  private String country;
  private String state;
  private String city;
  private List<String> phones;
  private ObjectId adminEmployeeId;
  private String description;
  private String coordinates;
}
