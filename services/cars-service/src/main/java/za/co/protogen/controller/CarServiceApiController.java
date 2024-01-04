package za.co.protogen.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;

import java.util.Comparator;
import java.util.List;
@RestController
@RequestMapping("/cars")
public class CarServiceApiController {

    private final CarService carService;

    public CarServiceApiController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/vin/{vin}")
    public Car getCarById(@PathVariable String vin) {
        return carService.getCarById(vin);
    }

    @GetMapping("/make/{make}")
    public List<Car> getCarsByMake(@PathVariable String make) {
        return carService.getCarsByMake(make);
    }

    @GetMapping("/color/{color}")
    public List<Car> getCarsByColor(@PathVariable String color) {
        return carService.getCarsByColor(color);
    }

    @GetMapping("/year/{year}")
    public List<Car> getCarsByYear(@PathVariable Integer year) {
        return carService.getCarsByYear(year);
    }

    @DeleteMapping("/vin/{vin}")
    public void removeCarById(@PathVariable String vin) {
        carService.removeCar(vin);
    }

    @PutMapping("/vin/{vin}")
    public void updateCar(@PathVariable String vin, @RequestBody Car car) {
        carService.updateCar(vin, car );
    }

    @GetMapping("/averageMileage")
    public double getAverageMileage(){
        return carService.calculateAverageMileage();
    }
    @GetMapping("/cheapestCar")
    public Car getCheapestCar(){
        return carService.findCheapestCar();
    }

    @GetMapping("/mostExpensiveCar")
    public Car getMostExpensiveCar(){
        return carService.findMostExpensiveCar();
    }

    @GetMapping("/newestCar")
    public Car getNewestCar(){
        return carService.findNewestCar();
    }

    @GetMapping("/oldestCar")
    public Car getOldestCar(){
        return carService.findOldestCar();
    }
    @GetMapping("/searchCars")
    public List<Car> searchCars(
            @RequestParam(name = "make", required = false) String make,
            @RequestParam(name = "model", required = false) String model,
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "engine", required = false) String engine,
            @RequestParam(name = "transmission", required = false) String transmission,
            @RequestParam(name = "fuelType", required = false) String fuelType,
            @RequestParam(name = "mileage", required = false) Integer mileage,
            @RequestParam(name = "ownerId", required = false) Integer ownerId,
            @RequestParam(name = "minimumPrice", required = false) Integer minimumPrice,
            @RequestParam(name = "maximumPrice", required = false) Integer maximumPrice
            ){
        return carService.searchCars(make,model,year,color,engine,transmission,fuelType,mileage,ownerId,minimumPrice,maximumPrice);
    }
}


