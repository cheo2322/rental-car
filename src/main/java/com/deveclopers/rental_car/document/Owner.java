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
public class Owner {

  @Id private String id;
  private List<ObjectId> carIds;
  private ObjectId personId;
}
