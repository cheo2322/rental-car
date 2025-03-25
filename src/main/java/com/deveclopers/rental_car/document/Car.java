package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Car {

  @Id private String id;

  private Brand brand;
  private Model model;
  private Integer year;
  private String color;
  private String plate;
  private Integer doors;
  private Integer seats;
  private Category category;
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
  private ObjectId ownerPersonId;
  private String assemblyCountry;
  private String description;
}
