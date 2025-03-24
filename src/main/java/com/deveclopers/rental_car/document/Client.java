package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document
@Getter
@Setter
public class Client {

    @Id
    private String id;
    private DriverLicense driverLicense;
    private List<String> interests;

    @DocumentReference
    private Person person;
}
