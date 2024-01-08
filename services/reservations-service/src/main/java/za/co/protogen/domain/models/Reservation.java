package za.co.protogen.domain.models;

import java.time.LocalDate;

public class Reservation {
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String pickUpLocation ;
    private String dropoffLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public Reservation() {
    }

    public Reservation(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropoffLocation) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickUpLocation = pickUpLocation;
        this.dropoffLocation = dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;

    }
}
