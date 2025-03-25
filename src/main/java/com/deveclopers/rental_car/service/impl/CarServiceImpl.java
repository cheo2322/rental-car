package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CarDto;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import com.deveclopers.rental_car.mapper.CarMapper;
import com.deveclopers.rental_car.repository.BrandRepository;
import com.deveclopers.rental_car.repository.ModelRepository;
import com.deveclopers.rental_car.service.CarService;
import org.bson.types.ObjectId;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

  private final BrandRepository brandRepository;
  private final ModelRepository modelRepository;

  private static final CarMapper CAR_MAPPER = CarMapper.INSTANCE;

  public CarServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository) {
    this.brandRepository = brandRepository;
    this.modelRepository = modelRepository;
  }

  @Override
  public Mono<DefaultDto> createBrand(BrandDto brandDto) {
    Brand brand = CAR_MAPPER.dtoToEntity(brandDto); // TODO: Add the addedByEmployeeId field

    return brandRepository
        .save(brand)
        .onErrorResume(DuplicateKeyException.class, ex -> Mono.empty())
        .map(savedBrand -> new DefaultDto(savedBrand.getId()));
  }

  @Override
  public Mono<DefaultDto> createModel(ModelDto modelDto) {
    return brandRepository
        .findByName(modelDto.brandName().toUpperCase())
        .flatMap(
            brand -> {
              Model model =
                  CAR_MAPPER.dtoToEntity(modelDto); // TODO: TD: Add the addedByEmployeeId field
              model.setBrandId(new ObjectId(brand.getId()));

              return modelRepository
                  .save(model)
                  .map(modelDB -> new DefaultDto(modelDB.getId()))
                  .onErrorResume(
                      DuplicateKeyException.class,
                      ex -> Mono.empty()); // TODO: TD: Add exception handler
            })
        .switchIfEmpty(Mono.defer(() -> Mono.empty())); // TODO: TD: Add exception handler
  }

  @Override
  public Mono<DefaultDto> createCar(CarDto carDto) {
    return null;
  }
}
