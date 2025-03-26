package com.deveclopers.rental_car.controller;

import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.RentRecordDto;
import com.deveclopers.rental_car.service.RentRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rental-car/v1/records")
public class RentRecordController {

  private final RentRecordService rentRecordService;

  public RentRecordController(RentRecordService rentRecordService) {
    this.rentRecordService = rentRecordService;
  }

  @PostMapping
  public Mono<ResponseEntity<DefaultDto>> createRentRecord(
      @RequestBody RentRecordDto rentRecordDto) {
    return rentRecordService
        .createRentRecord(rentRecordDto)
        .map(defaultDto -> ResponseEntity.status(HttpStatus.CREATED).body(defaultDto))
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }
}
