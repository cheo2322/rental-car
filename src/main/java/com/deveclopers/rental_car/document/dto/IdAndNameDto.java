package com.deveclopers.rental_car.document.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record IdAndNameDto(
    String id, @Size(min = 2, message = "Minimum size is equal to 2.") @NotNull String name) {}
