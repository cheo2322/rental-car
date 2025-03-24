package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class Employee {

    @Id
    private String id;

    private LocalDate start;
    private LocalDate end;
    private Double payment;
    private Boolean isActive;
}
