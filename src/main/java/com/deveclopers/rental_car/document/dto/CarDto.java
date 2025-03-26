package com.deveclopers.rental_car.document.dto;

public record CarDto(
    String brandName,
    String modelName,
    Integer year,
    String color,
    String plate,
    Integer doors,
    Integer seats,
    String categoryName,
    Double value,
    Double maximumWeight,
    Double hourPrice,
    Double dayPrice,
    String condition,
    String assemblyCountry,
    String description) {}
