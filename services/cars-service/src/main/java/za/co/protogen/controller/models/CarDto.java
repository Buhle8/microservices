package za.co.protogen.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * CarDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-06T11:50:07.485639700Z[Europe/London]")


public class CarDto {
  @JsonProperty("carId")
  private BigDecimal carId = null;

  @JsonProperty("vin")
  private String vin = null;

  @JsonProperty("make")
  private String make = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("year")
  private BigDecimal year = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("engine")
  private BigDecimal engine = null;

  @JsonProperty("transmission")
  private String transmission = null;

  @JsonProperty("fuelType")
  private String fuelType = null;

  @JsonProperty("mileage")
  private BigDecimal mileage = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @JsonProperty("ownerId")
  private BigDecimal ownerId = null;

  @JsonProperty("features")
  private List features = null;

  public CarDto carId(BigDecimal carId) {
    this.carId = carId;
    return this;
  }

  /**
   * Get carId
   * @return carId
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getCarId() {
    return carId;
  }

  public void setCarId(BigDecimal carId) {
    this.carId = carId;
  }

  public CarDto vin(String vin) {
    this.vin = vin;
    return this;
  }

  /**
   * Get vin
   * @return vin
   **/
  @Schema(description = "")
  
    public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public CarDto make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
   **/
  @Schema(description = "")
  
    public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public CarDto model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   **/
  @Schema(description = "")
  
    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public CarDto year(BigDecimal year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getYear() {
    return year;
  }

  public void setYear(BigDecimal year) {
    this.year = year;
  }

  public CarDto color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
   **/
  @Schema(description = "")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public CarDto engine(BigDecimal engine) {
    this.engine = engine;
    return this;
  }

  /**
   * Get engine
   * @return engine
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getEngine() {
    return engine;
  }

  public void setEngine(BigDecimal engine) {
    this.engine = engine;
  }

  public CarDto transmission(String transmission) {
    this.transmission = transmission;
    return this;
  }

  /**
   * Get transmission
   * @return transmission
   **/
  @Schema(description = "")
  
    public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public CarDto fuelType(String fuelType) {
    this.fuelType = fuelType;
    return this;
  }

  /**
   * Get fuelType
   * @return fuelType
   **/
  @Schema(description = "")
  
    public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public CarDto mileage(BigDecimal mileage) {
    this.mileage = mileage;
    return this;
  }

  /**
   * Get mileage
   * @return mileage
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getMileage() {
    return mileage;
  }

  public void setMileage(BigDecimal mileage) {
    this.mileage = mileage;
  }

  public CarDto price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public CarDto ownerId(BigDecimal ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(BigDecimal ownerId) {
    this.ownerId = ownerId;
  }

  public CarDto features(List features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
   **/
  @Schema(description = "")
  
    @Valid
    public List getFeatures() {
    return features;
  }

  public void setFeatures(List features) {
    this.features = features;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarDto carDto = (CarDto) o;
    return Objects.equals(this.carId, carDto.carId) &&
        Objects.equals(this.vin, carDto.vin) &&
        Objects.equals(this.make, carDto.make) &&
        Objects.equals(this.model, carDto.model) &&
        Objects.equals(this.year, carDto.year) &&
        Objects.equals(this.color, carDto.color) &&
        Objects.equals(this.engine, carDto.engine) &&
        Objects.equals(this.transmission, carDto.transmission) &&
        Objects.equals(this.fuelType, carDto.fuelType) &&
        Objects.equals(this.mileage, carDto.mileage) &&
        Objects.equals(this.price, carDto.price) &&
        Objects.equals(this.ownerId, carDto.ownerId) &&
        Objects.equals(this.features, carDto.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carId, vin, make, model, year, color, engine, transmission, fuelType, mileage, price, ownerId, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarDto {\n");
    
    sb.append("    carId: ").append(toIndentedString(carId)).append("\n");
    sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    transmission: ").append(toIndentedString(transmission)).append("\n");
    sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
    sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
