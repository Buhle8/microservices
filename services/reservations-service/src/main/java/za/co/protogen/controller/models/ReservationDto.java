package za.co.protogen.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * ReservationDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-07T19:37:13.244825700Z[Europe/London]")


public class ReservationDto {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("userId")
  private BigDecimal userId = null;

  @JsonProperty("carId")
  private BigDecimal carId = null;

  @JsonProperty("fromDate")
  private LocalDate fromDate = null;

  @JsonProperty("toDate")
  private LocalDate toDate = null;

  @JsonProperty("pickUpLocation")
  private String pickUpLocation = null;

  @JsonProperty("dropOffLocation")
  private String dropOffLocation = null;

  public ReservationDto id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public ReservationDto userId(BigDecimal userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getUserId() {
    return userId;
  }

  public void setUserId(BigDecimal userId) {
    this.userId = userId;
  }

  public ReservationDto carId(BigDecimal carId) {
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

  public ReservationDto fromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
   **/
  @Schema(description = "")
  
    @Valid
    public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public ReservationDto toDate(LocalDate toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
   **/
  @Schema(description = "")
  
    @Valid
    public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  public ReservationDto pickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
    return this;
  }

  /**
   * Get pickUpLocation
   * @return pickUpLocation
   **/
  @Schema(description = "")
  
    public String getPickUpLocation() {
    return pickUpLocation;
  }

  public void setPickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
  }

  public ReservationDto dropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
    return this;
  }

  /**
   * Get dropOffLocation
   * @return dropOffLocation
   **/
  @Schema(description = "")
  
    public String getDropOffLocation() {
    return dropOffLocation;
  }

  public void setDropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationDto reservationDto = (ReservationDto) o;
    return Objects.equals(this.id, reservationDto.id) &&
        Objects.equals(this.userId, reservationDto.userId) &&
        Objects.equals(this.carId, reservationDto.carId) &&
        Objects.equals(this.fromDate, reservationDto.fromDate) &&
        Objects.equals(this.toDate, reservationDto.toDate) &&
        Objects.equals(this.pickUpLocation, reservationDto.pickUpLocation) &&
        Objects.equals(this.dropOffLocation, reservationDto.dropOffLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, carId, fromDate, toDate, pickUpLocation, dropOffLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    carId: ").append(toIndentedString(carId)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    pickUpLocation: ").append(toIndentedString(pickUpLocation)).append("\n");
    sb.append("    dropOffLocation: ").append(toIndentedString(dropOffLocation)).append("\n");
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
