package za.co.protogen.domain;

import java.util.ArrayList;

public class Car {
    private String make;

    private String model;
    private Integer year;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private Integer mileage;
    private String vin;
    private Integer price;
    private Integer ownerId;
    private ArrayList<String> features;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                ", ownerId=" + ownerId +
                ", features=" + features +
                '}';
    }

    public Car(String make, String model, Integer year, String color, String engine, String transmission, String fuelType, Integer mileage, String vin, Integer price, Integer ownerId, ArrayList<String> features) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.vin = vin;
        this.price = price;
        this.ownerId = ownerId;
        this.features = features;

    }
}
