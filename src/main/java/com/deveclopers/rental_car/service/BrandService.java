package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import reactor.core.publisher.Flux;

/** CRUD operations for Brand document. */
public interface BrandService {

  /**
   * Get all brands.
   *
   * @return All Brand documents.
   */
  Flux<IdAndNameDto> getBrands();
}
