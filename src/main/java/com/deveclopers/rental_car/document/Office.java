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
public class Office {

    @Id
    private String id;

    private String country;
    private String state;
    private String city;
    private List<String> phones;

    @DocumentReference
    private Employee admin;

    private String description;
    private String coordinates;
}
