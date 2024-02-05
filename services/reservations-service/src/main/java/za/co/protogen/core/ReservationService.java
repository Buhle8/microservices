package za.co.protogen.core;

import org.threeten.bp.LocalDate;
import za.co.protogen.persistance.models.Reservation;

import java.util.List;


public interface ReservationService {
    void addReservation(Reservation reservation);

    void removeReservation(Long id);

    Reservation getReservationById(Long id);

    List<Reservation> getAllReservations();

    void updateReservation(Long id, Reservation updatedReservation);

    List<Reservation> searchReservations(Long id, Long userId, String carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation);

}
