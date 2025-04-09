package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** CRUD service for Model document. */
public interface ModelService {

  /**
   * Get Model by Brand.
   *
   * @param brandId to get the Model documents.
   * @return all Model wrapped in IdAndNumberDto filtered by Brand.
   */
  Flux<IdAndNameDto> getModelsByBrandId(String brandId);

  /**
   * Create a new Model from name, related to an existent Brand.
   *
   * @param brandId id of the Brand.
   * @param modelName name of the Model.
   * @return a DTO with the new Model information.
   */
  Mono<IdAndNameDto> createModelFromName(String brandId, String modelName);
}
