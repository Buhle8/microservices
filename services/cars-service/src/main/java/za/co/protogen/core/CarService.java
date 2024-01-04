package za.co.protogen.core;

import org.springframework.stereotype.Service;
import za.co.protogen.domain.Car;

import java.util.List;

@Service
public interface  CarService {
    void addCar(Car car);
    void removeCar(String vin);
    Car getCarById(String vin) ;
    List<Car> getAllCars();
    List<Car> getCarsByMake(String make);
    List<Car> getCarsByYear(Integer year);
    List<Car> getCarsByColor(String color);
    void updateCar(String vin, Car updatedCar);
    Double calculateAverageMileage();
    Car findCheapestCar();
    Car findMostExpensiveCar();
    Car findNewestCar();
    Car findOldestCar();
    List<Car>searchCars(String make,String model, Integer year, String color,String engine,
                        String transmission, String fuelType, Integer mileage, Integer ownerId,
                        Integer minimumPrice, Integer maximumPrice);
}
