package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class EmployeeRole {

    @Id
    private String id;

    @DocumentReference
    private Employee employee;

    @DocumentReference
    private Role role;

    private LocalDate start;
    private LocalDate end;
    private Boolean isActive;

    @DocumentReference
    private Office office;

    private String comments;
}
