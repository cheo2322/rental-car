package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import com.deveclopers.rental_car.mapper.ModelMapper;
import com.deveclopers.rental_car.repository.BrandRepository;
import com.deveclopers.rental_car.repository.ModelRepository;
import com.deveclopers.rental_car.service.ModelService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ModelServiceImpl implements ModelService {

  private final BrandRepository brandRepository;
  private final ModelRepository modelRepository;

  private static final ModelMapper MODEL_MAPPER = ModelMapper.INSTANCE;

  public ModelServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository) {
    this.brandRepository = brandRepository;
    this.modelRepository = modelRepository;
  }

  @Override
  public Flux<IdAndNameDto> getModelsByBrandId(String brandId) {
    return brandRepository
        .findById(brandId)
        .flatMapMany(
            brand ->
                modelRepository
                    .findByBrandId(new ObjectId(brandId))
                    .map(MODEL_MAPPER::instanceToDto));
  }
}
