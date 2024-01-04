package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public void addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        Constant.reservations.removeIf(reservation -> reservation.getId().equals(id));

    }

    @Override
    public Reservation getReservationById(Long id) {
        return Constant.reservations.stream().filter(reservation -> reservation.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Constant.reservations;
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
        return Constant.reservations.stream().filter(reservation -> reservation.getId().equals(id) || reservation.getCarId().equals(carId) ||
                reservation.getUserId().equals(userId) || reservation.getFromDate().equals(fromDate) || reservation.getToDate().equals(toDate) ||
                reservation.getPickUpLocation().equalsIgnoreCase(pickUpLocation) || reservation.getDropoffLocation().equalsIgnoreCase(dropOffLocation)).collect(Collectors.toList());
    }
}
