package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Car;
import com.deveclopers.rental_car.document.Category;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CarDto;
import com.deveclopers.rental_car.document.dto.CategoryDto;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/** Service for CRUD and all functionalities related to Car, Brand, Model and Category documents. */
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
   * Create a new {@link Category} document.
   *
   * @param categoryDto with the data for Category.
   * @return a DefaultDto wrapping the Category ID.
   */
  Mono<DefaultDto> createCategory(CategoryDto categoryDto);

  /**
   * Create a new {@link Car} document.
   *
   * @param carDto with info from the Car.
   * @return the Car ID wrapped into a DefaultDto.
   */
  Mono<DefaultDto> createCar(CarDto carDto);

  /**
   * Get Car by filters.
   *
   * @param brandId to filter by Brand.
   * @return a Flux with Car filtered.
   */
  Flux<DefaultDto> getCars(List<String> brandId);
}
