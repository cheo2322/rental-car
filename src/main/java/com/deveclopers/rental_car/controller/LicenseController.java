package com.deveclopers.rental_car.controller;

import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.LicenseDto;
import com.deveclopers.rental_car.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rental-car/v1/licenses")
public class LicenseController {

  private final LicenseService licenseService;

  public LicenseController(LicenseService licenseService) {
    this.licenseService = licenseService;
  }

  @PostMapping("/{clientId}")
  public Mono<ResponseEntity<DefaultDto>> createLicense(
      @PathVariable String clientId, @RequestBody LicenseDto licenseDto) {

    return licenseService
        .createLicense(clientId, licenseDto)
        .map(defaultDto -> ResponseEntity.status(HttpStatus.CREATED).body(defaultDto))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
