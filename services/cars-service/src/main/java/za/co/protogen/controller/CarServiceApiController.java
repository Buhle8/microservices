package za.co.protogen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMappers;
import za.co.protogen.controller.api.CarsApi;
import za.co.protogen.controller.models.CarDto;
import za.co.protogen.core.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarServiceApiController implements CarsApi {

    private final CarService carService;
    private final CarMappers carMapper;

    public CarServiceApiController(CarService carService, CarMappers carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @Override
    public ResponseEntity<Void> addCar(CarDto body) {
        carService.addCar(carMapper.carDtoToCarEntity(body));
        return null;
    }

    @Override
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.getAllCars()));
    }


    @Override
    public ResponseEntity<List<CarDto>> getCarByColor(String color) {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.getCarsByColor(color)));
    }

    @Override
    public ResponseEntity<CarDto> getCarById(String vin) {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.getCarById(vin)));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarByMake(String make) {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.getCarsByMake(make)));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarByYear(Integer year) {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.getCarsByYear(year)));
    }

    @Override
    public ResponseEntity<Void> removeCarById(String vin) {
        carService.removeCar(vin);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<CarDto>> searchCars(String vin, String make, String model, Integer year,
                                                   String color, String engine, String transmission, String fuelType,
                                                   Integer mileage, Integer price, Integer ownerId, List features) {
        return ResponseEntity.ok(carMapper.carEntityToCarDto(carService.searchCars(vin,make,model,year,color,engine,transmission,
                fuelType,mileage,price,ownerId,features)));
    }

    @Override
    public ResponseEntity<Void> updateCar(String vin, CarDto body) {
        carService.updateCar(vin, carMapper.carDtoToCarEntity(body));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}


