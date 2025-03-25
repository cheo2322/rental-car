package com.deveclopers.rental_car.document;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class EmployeeRole {

  @Id private String id;
  private ObjectId employeeId;
  private ObjectId roleId;
  private LocalDate start;
  private LocalDate end;
  private Boolean isActive;
  private ObjectId officeId;
  private String comments;
}
