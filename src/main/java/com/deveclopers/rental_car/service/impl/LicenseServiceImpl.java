package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.LicenseDto;
import com.deveclopers.rental_car.mapper.LicenseMapper;
import com.deveclopers.rental_car.repository.ClientRepository;
import com.deveclopers.rental_car.repository.LicenseRepository;
import com.deveclopers.rental_car.service.LicenseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LicenseServiceImpl implements LicenseService {

  private final ClientRepository clientRepository;
  private final LicenseRepository licenseRepository;

  private static final LicenseMapper licenseMapper = LicenseMapper.INSTANCE;

  public LicenseServiceImpl(
      ClientRepository clientRepository, LicenseRepository licenseRepository) {
    this.clientRepository = clientRepository;
    this.licenseRepository = licenseRepository;
  }

  @Override
  public Mono<DefaultDto> createLicense(String clientId, LicenseDto licenseDto) {
    return clientRepository
        .findById(clientId)
        .flatMap(
            client ->
                licenseRepository
                    .save(licenseMapper.dtoToEntity(licenseDto))
                    .flatMap(
                        driverLicense -> {
                          client.setDriverLicense(driverLicense);

                          return clientRepository
                              .save(client)
                              .map(savedClient -> new DefaultDto(savedClient.getId()));
                        }))
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<DefaultDto> getLicense(String clientId) {
    return clientRepository
        .findById(clientId)
        .flatMap(
            client -> {
              if (client.getDriverLicense() != null
                  && !StringUtils.isBlank(client.getDriverLicense().getId())) {

                return Mono.just(new DefaultDto(client.getDriverLicense().getId()));
              }

              return Mono.empty();
            })
        .switchIfEmpty(Mono.empty());
  }
}
