package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Brand;
import com.deveclopers.rental_car.document.dto.IdAndNameDto;
import com.deveclopers.rental_car.mapper.BrandMapper;
import com.deveclopers.rental_car.repository.BrandRepository;
import com.deveclopers.rental_car.service.BrandService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BrandServiceImpl implements BrandService {

  private final BrandRepository brandRepository;

  private static final BrandMapper BRAND_MAPPER = BrandMapper.INSTANCE;

  public BrandServiceImpl(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
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
}
