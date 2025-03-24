package com.deveclopers.rental_car.document;

import com.deveclopers.rental_car.document.enums.Disability;
import com.deveclopers.rental_car.document.enums.Gender;
import com.deveclopers.rental_car.document.enums.MaritalStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class Person {

    @Id
    private String id;

    private String identification;
    private String name;
    private String lastname;
    private LocalDate born;
    private Gender gender;
    private String otherGender;
    private Disability disability;
    private String disabilityDescription;
    private Integer children;
    private MaritalStatus maritalStatus;
    private String phone;
    private String photo;
}
