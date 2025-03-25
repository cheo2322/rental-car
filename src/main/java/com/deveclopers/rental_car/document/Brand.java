package com.deveclopers.rental_car.document;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Brand {

  @Id private String id;

  @Indexed(unique = true)
  private String name;

  private String country;
  private String logo;
  private String description;
  private ObjectId addedByEmployeeId;
  private List<String> companies;
}
