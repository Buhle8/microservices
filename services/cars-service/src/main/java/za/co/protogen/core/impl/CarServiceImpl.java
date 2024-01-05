package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;


import za.co.protogen.persistance.Car;
import za.co.protogen.persistance.repository.CarRepository;
import za.co.protogen.utility.Constant;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
       carRepository.save(car);

    }
    @Override
    public void removeCar(String vin) {

        if (!carRepository.existsById(vin)){
           throw new IllegalStateException("car not found!!");
        }
        carRepository.deleteById(vin);
    }

    @Override
    public Car getCarById(String vin) {
        return carRepository.findById(vin).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return carRepository.findByMake(make);
    }

    @Override
    public List<Car> getCarsByYear(Integer year) {
        return carRepository.findByYear(year);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
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
    public Car findCheapestCar() {
        return carRepository.findAll().stream().min(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }
    @Override
    public Double calculateAverageMileage() {
        double totalMileage = carRepository.findAll().stream().mapToDouble(Car::getMileage).sum();
        return totalMileage / carRepository.findAll().size();
    }

    @Override
    public Car findMostExpensiveCar() {
        return carRepository.findAll().stream().max(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return carRepository.findAll().stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return carRepository.findAll().stream().min(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, Integer year, String color, String engine, String transmission,
                                String fuelType, Integer mileage, Integer ownerId, Integer minimumPrice, Integer maximumPrice) {
        return getAllCars().stream().filter(car -> car.getMake().equalsIgnoreCase(make) ||
                car.getModel().equalsIgnoreCase(model) || car.getYear().equals(year) ||
                car.getColor().equalsIgnoreCase(color) || car.getEngine().equalsIgnoreCase(engine) ||
                car.getTransmission().equalsIgnoreCase(transmission) ||
                car.getFuelType().equalsIgnoreCase(fuelType) || car.getMileage().equals(mileage) ||
                car.getOwnerId().equals(ownerId) || car.getPrice() >= minimumPrice || car.getPrice() <= maximumPrice).collect(Collectors.toList());
    }
}
