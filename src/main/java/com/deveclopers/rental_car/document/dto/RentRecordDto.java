package com.deveclopers.rental_car.document.dto;

import java.time.LocalDateTime;

public record RentRecordDto(
    String id,
    String carId,
    String clientId,
    String responsibleAgentEmployeeId,
    String responsibleManagerEmployeeId,
    String responsibleOfficeId,
    LocalDateTime start,
    LocalDateTime end,
    Boolean withDriver,
    String driverEmployeeId,
    Double totalToPay,
    Boolean isPickedUpAtOffice,
    String externalPlaceToPickUp,
    String coordinatesToPickup,
    Boolean isReturnedToOffice,
    String externalPlaceToRetrieve,
    String coordinatesToRetrieve,
    String type,
    Integer daysRent,
    Integer hoursRent,
    String invoiceNumber) {}
