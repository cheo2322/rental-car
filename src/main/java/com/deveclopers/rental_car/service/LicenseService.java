package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.LicenseDto;
import reactor.core.publisher.Mono;

/** Service for CRUD License document. */
public interface LicenseService {

  Mono<DefaultDto> createLicense(String clientId, LicenseDto licenseDto);
}
