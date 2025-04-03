package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import reactor.core.publisher.Flux;

/** CRUD service for Model document. */
public interface ModelService {

  /**
   * Get Model by Brand.
   *
   * @param brandId to get the Model documents.
   * @return all Model wrapped in IdAndNumberDto filtered by Brand.
   */
  Flux<IdAndNameDto> getModelsByBrandId(String brandId);
}
