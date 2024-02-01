package za.co.protogen.core.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistance.models.Reservation;
import za.co.protogen.persistance.repository.ReservationRepository;
import za.co.protogen.specification.ReservationSpecifications;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new IllegalStateException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElseGet(() -> (Reservation) ResponseEntity.status(HttpStatus.NOT_FOUND));
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
            existingReservation.setDropOffLocation(updatedReservation.getDropOffLocation());
        }
    }


    @Override
    public List<Reservation> searchReservations(Long id, Long userId,String carId, LocalDate
            fromDate, LocalDate toDate,  String pickUpLocation, String dropOffLocation) {
        Specification<Reservation> spec = Specification
                .where(ReservationSpecifications.idEquals(id))
                .or(ReservationSpecifications.userIdEquals(userId))
                .or(ReservationSpecifications.dateFrom(fromDate))
                .or(ReservationSpecifications.dateTo(toDate))
                .or(ReservationSpecifications.carIdEquals(carId))
                .or(ReservationSpecifications.pickUpLocationEquals(pickUpLocation))
                .or(ReservationSpecifications.dropOffLocationEquals(dropOffLocation));

        return reservationRepository.findAll(spec);
    }
}
