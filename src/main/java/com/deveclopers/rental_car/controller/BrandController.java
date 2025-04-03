package com.deveclopers.rental_car.controller;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import com.deveclopers.rental_car.service.BrandService;
import com.deveclopers.rental_car.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rental-car/v1/brands")
public class BrandController {

  private final BrandService brandService;
  private final ModelService modelService;

  public BrandController(BrandService brandService, ModelService modelService) {
    this.brandService = brandService;
    this.modelService = modelService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<IdAndNameDto> getBrands() {
    return brandService.getBrands();
  }

  @GetMapping("/{id}/models")
  @ResponseStatus(HttpStatus.OK)
  public Flux<IdAndNameDto> getModels(@PathVariable String id) {
    return modelService.getModelsByBrandId(id);
  }
}
