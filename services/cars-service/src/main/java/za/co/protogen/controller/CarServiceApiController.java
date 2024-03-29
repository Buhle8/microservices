package za.co.protogen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMappers;
import com.example.carsService.api.CarsApi;
import com.example.carsService.models.CarDto;
import za.co.protogen.core.CarService;

import java.util.List;

@RestController
@RequestMapping
public class CarServiceApiController implements CarsApi {
    private static final Logger logger = LoggerFactory.getLogger(CarServiceApiController.class);

    private final CarService carService;

    public CarServiceApiController(CarService carService) {
        this.carService = carService;
    }

    @Override
    public ResponseEntity<Void> addCar(CarDto body) {
        logger.info("adding car");
        carService.addCar(CarMappers.CAR.carDtoToCarEntity(body));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CarDto>> getAllCars() {
        logger.info("getting all cars");
        List<CarDto> carDtos = CarMappers.CAR.carEntityToCarDto(carService.getAllCars());
        return ResponseEntity.ok(carDtos);
    }


    @Override
    public ResponseEntity<List<CarDto>> getCarByColor(String color) {
        logger.info("getting cars by color " + color);
        return ResponseEntity.ok(CarMappers.CAR.carEntityToCarDto(carService.getCarsByColor(color)));
    }

    @Override
    public ResponseEntity<CarDto> getCarById(String vin) {
        logger.info("getting car by vin " + vin);
        return ResponseEntity.ok(CarMappers.CAR.carEntityToCarDto(carService.getCarById(vin)));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarByMake(String make) {
        logger.info("getting cars by make " + make);
        return ResponseEntity.ok(CarMappers.CAR.carEntityToCarDto(carService.getCarsByMake(make)));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarByYear(Integer year) {
        logger.info("getting cars by year " + year);
        return ResponseEntity.ok(CarMappers.CAR.carEntityToCarDto(carService.getCarsByYear(year)));
    }

    @Override
    public ResponseEntity<Void> removeCarById(String vin) {
        carService.removeCar(vin);
        logger.info(" removing car by vin" + vin);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Void> updateCar(String vin, CarDto body) {
        carService.updateCar(vin, CarMappers.CAR.carDtoToCarEntity(body));
        logger.info("updating cars");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<CarDto>> searchCars(String vin, String make, String model, Integer year, String color,
                                                   String engine, String transmission, String fuelType, Integer mileage,
                                                   Integer price, Integer ownerId, List<String> feature) {
        List<CarDto> carDtos = CarMappers.CAR.carEntityToCarDto(carService.searchCars(vin, make, model, year, color, engine, transmission, fuelType,
                mileage, price, ownerId, feature));
        return ResponseEntity.ok(carDtos);
    }
}


