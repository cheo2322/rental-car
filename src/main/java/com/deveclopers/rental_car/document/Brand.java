package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Brand {

    @Id
    private String id;

    private String name;
    private String country;
    private String logo;
    private String description;
}
