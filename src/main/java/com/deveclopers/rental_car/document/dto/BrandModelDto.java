package com.deveclopers.rental_car.document.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BrandModelDto(
    String brandId,
    String modelId,
    @NotNull @NotBlank String brandName,
    @NotNull @NotBlank String modelName) {}
