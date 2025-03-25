package com.deveclopers.rental_car.document.dto;

import java.util.List;

public record BrandDto(
    String name, String country, String logo, String description, List<String> companies) {}
