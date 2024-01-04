package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class CarServiceImpl implements CarService {
    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(String vin) {
        Constant.cars.removeIf(car -> car.getVin().equals(vin));
    }

    @Override
    public Car getCarById(String vin) {
        return Constant.cars.stream().filter(car -> car.getVin().equals(vin)).findFirst().orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return Constant.cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return Constant.cars.stream().filter(car -> car.getMake().equalsIgnoreCase(make)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByYear(Integer year) {
        return Constant.cars.stream().filter(car -> Objects.equals(car.getYear(), year)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return Constant.cars.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    @Override
    public void updateCar(String vin, Car updatedCar) {
        Car existingCar = getCarById(vin);
        if (existingCar != null){
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setYear(updatedCar.getYear());
            existingCar.setColor(updatedCar.getColor());
            existingCar.setEngine(updatedCar.getEngine());
            existingCar.setMileage(updatedCar.getMileage());
            existingCar.setVin(updatedCar.getVin());
            existingCar.setFuelType(updatedCar.getFuelType());
            existingCar.setTransmission(updatedCar.getTransmission());
            existingCar.setFeatures(updatedCar.getFeatures());
            existingCar.setPrice(updatedCar.getPrice());
            existingCar.setOwnerId(updatedCar.getOwnerId());
        }

    }

    @Override
    public Double calculateAverageMileage() {
        double totalMileage = Constant.cars.stream().mapToDouble(Car::getMileage).sum();
        return totalMileage / Constant.cars.size();
    }

    @Override
    public Car findCheapestCar() {
        return Constant.cars.stream().min(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        return Constant.cars.stream().max(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return Constant.cars.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return Constant.cars.stream().min(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, Integer year, String color, String engine, String transmission,
                                String fuelType, Integer mileage, Integer ownerId, Integer minimumPrice, Integer maximumPrice) {
        return Constant.cars.stream().filter(car -> car.getMake().equalsIgnoreCase(make) ||
                car.getModel().equalsIgnoreCase(model) || car.getYear().equals(year) ||
                car.getColor().equalsIgnoreCase(color) || car.getEngine().equalsIgnoreCase(engine) ||
                car.getTransmission().equalsIgnoreCase(transmission) ||
                car.getFuelType().equalsIgnoreCase(fuelType) || car.getMileage().equals(mileage) ||
                car.getOwnerId().equals(ownerId) || car.getPrice() >= minimumPrice || car.getPrice() <= maximumPrice).collect(Collectors.toList());
    }
}
