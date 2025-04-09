package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.Model;
import com.deveclopers.rental_car.document.dto.BrandModelDto;
import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import com.deveclopers.rental_car.mapper.BrandMapper;
import com.deveclopers.rental_car.repository.BrandRepository;
import com.deveclopers.rental_car.repository.ModelRepository;
import com.deveclopers.rental_car.service.BrandService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BrandServiceImpl implements BrandService {

  private final BrandRepository brandRepository;
  private final ModelRepository modelRepository;

  private static final BrandMapper BRAND_MAPPER = BrandMapper.INSTANCE;

  public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository) {
    this.brandRepository = brandRepository;
    this.modelRepository = modelRepository;
  }

  @Override
  public Flux<IdAndNameDto> getBrands() {
    return brandRepository.findAll().map(BRAND_MAPPER::instanceToDto);
  }

  @Override
  public Mono<IdAndNameDto> createBrandFromName(String name) {
    Brand brand = new Brand();
    brand.setName(name);

    return brandRepository.save(brand).map(BRAND_MAPPER::instanceToDto);
  }

  @Override
  public Mono<BrandModelDto> createBrandAndModel(String brandName, String modelName) {
    Brand brand = new Brand();
    brand.setName(brandName);

    return brandRepository
        .save(brand)
        .flatMap(
            brandDB -> {
              Model model = new Model();
              model.setName(modelName);
              model.setBrandId(new ObjectId(brandDB.getId()));

              return modelRepository
                  .save(model)
                  .map(
                      modelDB ->
                          new BrandModelDto(
                              brandDB.getId(),
                              modelDB.getId(),
                              brandDB.getName(),
                              modelDB.getName()));
            });
  }
}
