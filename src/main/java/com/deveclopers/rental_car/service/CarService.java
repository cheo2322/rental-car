package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Car;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CarDto;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import reactor.core.publisher.Mono;

/** Service for CRUD and all functionalities related to Car document. */
public interface CarService {

  /**
   * Create a new {@link Brand} document.
   *
   * @param brandDto with the info with the Brand.
   * @return a DefaultDto wrapping the Brand ID.
   */
  Mono<DefaultDto> createBrand(BrandDto brandDto);

  /**
   * Create a new {@link Model} document.
   *
   * @param modelDto with the info from the Model.
   * @return a DefaultDto wrapping the Model ID.
   */
  Mono<DefaultDto> createModel(ModelDto modelDto);

  /**
   * Create a new {@link Car} document.
   *
   * @param carDto with info from the Car.
   * @return the Car ID wrapped into a DefaultDto.
   */
  Mono<DefaultDto> createCar(CarDto carDto);
}
