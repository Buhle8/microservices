package za.co.protogen.controller;

import com.example.reservationsService.api.ReservationsApi;
import com.example.reservationsService.models.ReservationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDate;
import za.co.protogen.adapter.ReservationMappers;
import za.co.protogen.core.ReservationService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping
public class ReservationServiceApiController implements ReservationsApi {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceApiController.class);
    private final ReservationService reservationService;



    @Autowired
    public ReservationServiceApiController(ReservationService reservationService) {
        this.reservationService = reservationService;

    }

    @Override
    public ResponseEntity<Void> addReservation(ReservationDto body) {
        reservationService.addReservation(ReservationMappers.RESERVATION.reservationDtoToReservationEntity(body));
        logger.info("adding reservations");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        logger.info("getting all reservations");
        List<ReservationDto> reservationDtos = ReservationMappers.RESERVATION.reservationEntityToReservationDto(reservationService.getAllReservations());
        return ResponseEntity.ok(reservationDtos);
    }

    @Override
    public ResponseEntity<ReservationDto> getReservationById(BigDecimal id) {
        logger.info("getting reservation by id " + id);
        return ResponseEntity.ok((ReservationDto) ReservationMappers.RESERVATION.reservationEntityToReservationDto(reservationService.getReservationById(id.longValue())));
    }

    @Override
    public ResponseEntity<Void> removeReservation(BigDecimal id) {
        reservationService.removeReservation(id.longValue());
        logger.info("removing reservation by id " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ReservationDto>> searchReservations(BigDecimal id, BigDecimal userId, String carId,
                                                                   LocalDate fromDate, LocalDate toDate,
                                                                   String pickUpLocation, String dropOffLocation) {
        logger.info("searching reservations");
        Long idValue = (id != null) ? id.longValue() : null;
        Long userIdValue = (userId != null) ? userId.longValue() : null;

        List<ReservationDto> reservationDtos = ReservationMappers.RESERVATION.reservationEntityToReservationDto(
                reservationService.searchReservations(idValue, userIdValue, carId, fromDate, toDate, pickUpLocation, dropOffLocation));

        return ResponseEntity.ok(reservationDtos);
    }

    @Override
    public ResponseEntity<Void> updateReservation(BigDecimal id, ReservationDto body) {
        reservationService.updateReservation(id.longValue(), ReservationMappers.RESERVATION.reservationDtoToReservationEntity(body));
        logger.info("updating reservation");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
