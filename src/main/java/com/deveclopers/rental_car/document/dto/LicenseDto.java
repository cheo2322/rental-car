package com.deveclopers.rental_car.document.dto;

import java.time.LocalDate;

public record LicenseDto(String number, String type, LocalDate expedition, LocalDate expiration) {}
