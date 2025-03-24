package com.deveclopers.rental_car.document.dto;

import com.deveclopers.rental_car.document.Person;
import com.deveclopers.rental_car.document.enums.Disability;
import com.deveclopers.rental_car.document.enums.Gender;
import com.deveclopers.rental_car.document.enums.MaritalStatus;
import java.time.LocalDate;

/** DTO for {@link Person} document */
public record PersonDto(
    String identification,
    String name,
    String lastName,
    LocalDate born,
    Gender gender,
    String otherGender,
    Disability disability,
    String disabilityDescription,
    Integer children,
    MaritalStatus maritalStatus,
    String phone) {}
