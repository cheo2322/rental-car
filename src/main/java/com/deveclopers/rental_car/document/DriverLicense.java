package com.deveclopers.rental_car.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class DriverLicense {

    @Id
    private String id;

    private String number;
    private String type;
    private LocalDate expedition;
    private LocalDate expiration;
    private String photo;
}
