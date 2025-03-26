package com.deveclopers.rental_car.service;

import com.deveclopers.rental_car.document.RentRecord;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.RentRecordDto;
import reactor.core.publisher.Mono;

/** Service for CRUD and all functionalities for RentRecord documents. */
public interface RentRecordService {

  /**
   * Create a new {@link RentRecord} document.
   *
   * @param rentRecordDto ith data for RentRecord.
   * @return a DefaultDto wrapping the RentRecord ID.
   */
  Mono<DefaultDto> createRentRecord(RentRecordDto rentRecordDto);
}
