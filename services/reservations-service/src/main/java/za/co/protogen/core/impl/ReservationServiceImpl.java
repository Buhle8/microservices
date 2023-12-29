package za.co.protogen.core.impl;

import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {
    private final List<Reservation> reservationList;

    public ReservationServiceImpl(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        reservationList.removeIf(reservation -> reservation.getId().equals(id));

    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationList.stream().filter(reservation -> reservation.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationList;
    }

    @Override
    public void updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id);
        if (existingReservation != null) {
            existingReservation.setUserId(updatedReservation.getUserId());
            existingReservation.setCarId(updatedReservation.getCarId());
            existingReservation.setFromDate(updatedReservation.getFromDate());
            existingReservation.setToDate((updatedReservation.getToDate()));
            existingReservation.setPickUpLocation(updatedReservation.getPickUpLocation());
            existingReservation.setDropoffLocation(updatedReservation.getDropoffLocation());

        }
    }

    @Override
    public List<Reservation> searchReservations(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation) {
        return reservationList.stream().filter(reservation -> reservation.getId().equals(id) || reservation.getCarId().equals(carId) ||
                reservation.getUserId().equals(userId) || reservation.getFromDate().equals(fromDate) || reservation.getToDate().equals(toDate) ||
                reservation.getPickUpLocation().equalsIgnoreCase(pickUpLocation) || reservation.getDropoffLocation().equalsIgnoreCase(dropOffLocation)).collect(Collectors.toList());
    }
}
