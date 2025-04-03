package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** CRUD operations for Brand document. */
public interface BrandService {

  /**
   * Get all brands.
   *
   * @return All Brand documents.
   */
  Flux<IdAndNameDto> getBrands();

  /**
   * Create a new Brand document by using the name only.
   *
   * @param name for the Brand.
   * @return The id from DB and the name of the new Brand.
   */
  Mono<IdAndNameDto> createBrandFromName(String name);
}
