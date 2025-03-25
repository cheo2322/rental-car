package com.deveclopers.rental_car.controller;

import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CategoryDto;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import com.deveclopers.rental_car.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rental-car/v1/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping("/brands")
  public Mono<ResponseEntity<DefaultDto>> createBrand(@RequestBody BrandDto brandDto) {
    return carService
        .createBrand(brandDto)
        .map(defaultDto -> ResponseEntity.status(HttpStatus.CREATED).body(defaultDto))
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @PostMapping("/models")
  public Mono<ResponseEntity<DefaultDto>> createModel(@RequestBody ModelDto modelDto) {
    return carService
        .createModel(modelDto)
        .map(defaultDto -> ResponseEntity.status(HttpStatus.CREATED).body(defaultDto))
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @PostMapping("/categories")
  public Mono<ResponseEntity<DefaultDto>> createCategory(@RequestBody CategoryDto categoryDto) {
    return carService
        .createCategory(categoryDto)
        .map(defaultDto -> ResponseEntity.status(HttpStatus.CREATED).body(defaultDto))
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }
}
