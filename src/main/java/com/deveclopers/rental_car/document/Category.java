package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
@Getter
@Setter
public class Category {

    @Id
    private String id;

    private String name;
    private String description;

    @DocumentReference
    private Brand brand;
}
