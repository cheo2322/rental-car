package com.deveclopers.rental_car.document;

import com.deveclopers.rental_car.document.enums.RentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Rent {

    @Id
    private String id;

    @DocumentReference
    private Car car;

    @DocumentReference
    private Client client;

    @DocumentReference
    private Employee responsibleAgent;

    @DocumentReference
    private Employee responsibleManager;

    @DocumentReference
    private Office responsibleOffice;

    private LocalDateTime rentDate;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean withDriver;

    @DocumentReference
    private Employee driver;

    private Double totalToPay;
    private String placeToPickUp;
    private String coordinatesToPickup;
    private String placeToRetrieve;
    private String coordinatesToRetrieve;

    private RentType type;
    private Integer daysRent;
    private Integer hoursRent;
    private String invoiceNumber;
}
