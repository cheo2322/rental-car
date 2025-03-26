package com.deveclopers.rental_car.service.impl;

import com.deveclopers.rental_car.document.Car;
import com.deveclopers.rental_car.document.Client;
import com.deveclopers.rental_car.document.dto.DefaultDto;
import com.deveclopers.rental_car.document.dto.RentRecordDto;
import com.deveclopers.rental_car.mapper.RentRecordMapper;
import com.deveclopers.rental_car.repository.CarRepository;
import com.deveclopers.rental_car.repository.ClientRepository;
import com.deveclopers.rental_car.repository.RentRecordRepository;
import com.deveclopers.rental_car.service.RentRecordService;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RentRecordServiceImpl implements RentRecordService {

  private final CarRepository carRepository;
  private final RentRecordRepository rentRecordRepository;
  private final ClientRepository clientRepository;

  private static final RentRecordMapper RENT_RECORD_MAPPER = RentRecordMapper.INSTANCE;

  public RentRecordServiceImpl(
      CarRepository carRepository,
      RentRecordRepository rentRecordRepository,
      ClientRepository clientRepository) {
    this.carRepository = carRepository;
    this.rentRecordRepository = rentRecordRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public Mono<DefaultDto> createRentRecord(RentRecordDto rentRecordDto) {
    String id = rentRecordDto.carId();
    return carRepository
        .findById(id)
        .flatMap(verifyClient(rentRecordDto))
        .switchIfEmpty(
            Mono.defer(
                () -> {
                  System.out.println("Car does not exist.");
                  return Mono.empty();
                }));
  }

  /**
   * Verify the Client.
   *
   * @param rentRecordDto with the Client data to be verified.
   * @return the DefaultDto with the RentRecord. Mono.empty() if something fails.
   */
  private Function<Car, Mono<? extends DefaultDto>> verifyClient(RentRecordDto rentRecordDto) {
    return car -> {
      if (!(car.getIsAvailable() && car.getIsActive())) {
        return Mono.empty();
      }
      car.setIsAvailable(false);

      return clientRepository
          .findById(rentRecordDto.clientId())
          .flatMap(addRentRecord(rentRecordDto, car))
          .switchIfEmpty(
              Mono.defer(
                  () -> {
                    System.out.println("Client does not exist.");
                    return Mono.empty();
                  }));
    };
  }

  /**
   * Add the RentRecord document once the Client has been verified.
   *
   * @param rentRecordDto with data for RentRecord document.
   * @param car to be updated.
   * @return the DefaultDto with the new RentRecord ID. Mono.empty() if something fails.
   */
  private Function<Client, Mono<? extends DefaultDto>> addRentRecord(
      RentRecordDto rentRecordDto, Car car) {
    return client ->
        carRepository
            .save(car)
            .flatMap(
                carDB ->
                    rentRecordRepository
                        .save(RENT_RECORD_MAPPER.dtoToRecord(rentRecordDto))
                        .map(rentRecord -> new DefaultDto(rentRecord.getId())))
            .switchIfEmpty(
                Mono.defer(
                    () -> {
                      System.out.println("Car update failed.");
                      return Mono.empty();
                    }));
  }
}
