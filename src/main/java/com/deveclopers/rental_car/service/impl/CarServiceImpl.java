package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Car;
import com.deveclopers.rental_car.document.Category;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandDto;
import com.deveclopers.rental_car.document.dto.CarDto;
import com.deveclopers.rental_car.document.dto.CategoryDto;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.ModelDto;
import com.deveclopers.rental_car.mapper.CarMapper;
import com.deveclopers.rental_car.repository.BrandRepository;
import com.deveclopers.rental_car.repository.CarRepository;
import com.deveclopers.rental_car.repository.CategoryRepository;
import com.deveclopers.rental_car.repository.ModelRepository;
import com.deveclopers.rental_car.service.CarService;
import java.util.function.Function;
import org.bson.types.ObjectId;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

  private final BrandRepository brandRepository;
  private final ModelRepository modelRepository;
  private final CategoryRepository categoryRepository;
  private final CarRepository carRepository;

  private static final CarMapper CAR_MAPPER = CarMapper.INSTANCE;

  public CarServiceImpl(
      BrandRepository brandRepository,
      ModelRepository modelRepository,
      CategoryRepository categoryRepository,
      CarRepository carRepository) {

    this.brandRepository = brandRepository;
    this.modelRepository = modelRepository;
    this.categoryRepository = categoryRepository;
    this.carRepository = carRepository;
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
        .switchIfEmpty(Mono.empty()); // TODO: TD: Add exception handler
  }

  @Override
  public Mono<DefaultDto> createCategory(CategoryDto categoryDto) {
    return categoryRepository
        .save(CAR_MAPPER.dtoToEntity(categoryDto))
        .map(category -> new DefaultDto(category.getId()))
        .onErrorResume(DuplicateKeyException.class, ex -> Mono.empty());
  }

  @Override
  public Mono<DefaultDto> createCar(CarDto carDto) {
    return carRepository
        .findByPlate(carDto.plate().toUpperCase())
        .hasElement()
        .flatMap(getExistsHandler(carDto));
  }

  private Function<Boolean, Mono<DefaultDto>> getExistsHandler(CarDto carDto) {
    return exists -> {
      if (exists) {
        return Mono.empty();
      } else {
        return brandRepository
            .findByName(carDto.brandName())
            .flatMap(getBrandHandler(carDto))
            .switchIfEmpty(Mono.empty());
      }
    };
  }

  private Function<Brand, Mono<DefaultDto>> getBrandHandler(CarDto carDto) {
    return brand ->
        modelRepository
            .findByName(carDto.modelName())
            .flatMap(getModelHandler(carDto, brand))
            .switchIfEmpty(Mono.empty());
  }

  private Function<Model, Mono<DefaultDto>> getModelHandler(CarDto carDto, Brand brand) {
    return model ->
        categoryRepository
            .findByName(carDto.categoryName())
            .flatMap(getCategoryHandler(carDto, brand, model))
            .switchIfEmpty(Mono.empty());
  }

  private Function<Category, Mono<DefaultDto>> getCategoryHandler(
      CarDto carDto, Brand brand, Model model) {
    return category -> {
      Car car = CAR_MAPPER.dtoToEntity(carDto);
      car.setBrandId(new ObjectId(brand.getId()));
      car.setModelId(new ObjectId(model.getId()));
      car.setYear(carDto.year());
      car.setColor(carDto.color());
      car.setPlate(carDto.plate());
      car.setDoors(carDto.doors());
      car.setSeats(carDto.seats());
      car.setCategoryId(new ObjectId(category.getId()));
      car.setIsOwned(true);
      car.setIsVerified(true); // Take care with Roles

      return carRepository.save(car).map(savedCar -> new DefaultDto(savedCar.getId()));
    };
  }
}
