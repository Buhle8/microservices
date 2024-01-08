package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistance.models.Reservation;
import za.co.protogen.persistance.repository.ReservationRepository;

import org.threeten.bp.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository ;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long id){
        if(!reservationRepository.existsById(id)) {
            throw new IllegalStateException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
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
        return getAllReservations().stream().filter(reservation -> reservation.getId().equals(id) || reservation.getCarId().equals(carId) ||
                reservation.getUserId().equals(userId) || reservation.getFromDate().equals(fromDate) || reservation.getToDate().equals(toDate) ||
                reservation.getPickUpLocation().equalsIgnoreCase(pickUpLocation) || reservation.getDropoffLocation().equalsIgnoreCase(dropOffLocation)).collect(Collectors.toList());
    }
}
