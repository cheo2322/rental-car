package com.deveclopers.rental_car.repository;

import com.deveclopers.rental_car.document.RentRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRecordRepository extends ReactiveMongoRepository<RentRecord, String> {}
