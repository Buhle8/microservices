package za.co.protogen.core.impl;

import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.threeten.bp.LocalDate;
import za.co.protogen.controller.ReservationServiceApiController;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.feign.CarFeign;
import za.co.protogen.domain.feign.UserFeign;
import za.co.protogen.domain.restTemplate.Car;
import za.co.protogen.domain.restTemplate.User;
import za.co.protogen.persistance.models.Reservation;
import za.co.protogen.persistance.repository.ReservationRepository;
import za.co.protogen.specification.ReservationSpecifications;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarFeign carFeign;
    private final UserFeign userFeign;
    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    public ReservationServiceImpl(ReservationRepository reservationRepository, CarFeign carFeign, UserFeign userFeign) {
        this.reservationRepository = reservationRepository;
        this.carFeign = carFeign;
        this.userFeign = userFeign;
    }

    @Override
    public void addReservation(Reservation reservation) {
        String carId = reservation.getCarId();
        Long userId = reservation.getUserId();
        String authorizationKey = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("Authorization");
        System.out.println("auth-key: " + authorizationKey);

        if (userId != null) {
            try {
                User user = userFeign.getUserById(userId, authorizationKey);
                if (user == null) {
                    throw new NotFoundException("User id not found");
                }
            } catch (Exception e) {
                logger.error("Error retrieving user by id {}. Error: {}", userId, e.getMessage());
            }
        }

        if (carId != null && !carId.isEmpty()) {
            try {
                Car car = carFeign.getCarById(carId, authorizationKey);
                if (car == null) {
                    throw new NotFoundException("Car id not found");
                }
            } catch (Exception e) {
                logger.error("Error retrieving car by vin{}. Error:{}", carId, e.getMessage());
            }
        }
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
    public List<Reservation> searchReservations(Long id, Long userId, String carId, LocalDate
            fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation) {
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
