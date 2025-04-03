package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import reactor.core.publisher.Flux;

/** CRUD operations for Brand document. */
public interface BrandService {

  Flux<IdAndNameDto> getBrands();
}
