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
   * @return A DefaultDto containing the Client ID.
   */
  Mono<DefaultDto> createLicense(String clientId, LicenseDto licenseDto);

  /**
   * Get a {@link DriverLicense} document by clientId.
   *
   * @param clientId to get the license related with.
   * @return the License in case it exists, empty otherwise.
   */
  Mono<DefaultDto> getLicense(String clientId);
}
