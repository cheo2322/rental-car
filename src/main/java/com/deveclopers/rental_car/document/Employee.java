package com.deveclopers.rental_car.document;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Employee {

  @Id private String id;

  private LocalDate start;
  private LocalDate end;
  private Double payment;
  private Boolean isActive;
}
