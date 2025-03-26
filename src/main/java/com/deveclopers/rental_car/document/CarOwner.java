package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class CarOwner {

  @Id private String id;

  private ObjectId personId;
}
