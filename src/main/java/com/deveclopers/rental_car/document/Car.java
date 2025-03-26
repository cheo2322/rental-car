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
public class Car {

  @Id private String id;
  private ObjectId brandId;
  private ObjectId modelId;
  private Integer year;
  private String color;

  @Indexed(unique = true)
  private String plate;

  private Integer doors;
  private Integer seats;
  private ObjectId categoryId;
  private Double value;

  /*
  Weight in kg.
   */
  private Double maximumWeight;

  /*
  All prices are in United States' dollars.
   */
  private Double hourPrice;

  private Double dayPrice;
  private String condition;
  private Boolean isOwned;
  private ObjectId carOwnerPersonId;
  private String assemblyCountry;
  private String description;
  private Boolean isVerified;
  private List<String> photos;
  private Boolean isAvailable;
  private String unavailabilityReason;
  private Boolean isActive;
  private String nonActiveReason;
}
