package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Model {

  @Id private String id;

  @Indexed(unique = true)
  private String name;

  private String description;
  private ObjectId brandId;
  private String addedByEmployeeId;
}
