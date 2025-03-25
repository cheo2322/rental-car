package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.Client;
import com.deveclopers.rental_car.document.DriverLicense;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.LicenseDto;
import reactor.core.publisher.Mono;

/** Service for CRUD License document. */
public interface LicenseService {

  /**
   * Create a {@link DriverLicense} related with a {@link Client}.
   *
   * @param clientId to relate the License.
   * @param licenseDto
   * @return
   */
  Mono<DefaultDto> createLicense(String clientId, LicenseDto licenseDto);
}
