package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.adapter.ReservationMappers;
import za.co.protogen.controller.api.ReservationsApi;
import za.co.protogen.controller.models.ReservationDto;
import za.co.protogen.core.ReservationService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationServiceApiController implements ReservationsApi {
    private final ReservationService reservationService;
    private final ReservationMappers reservationMapper;
    RestTemplate restTemplate = new RestTemplate();


    @Autowired
    public ReservationServiceApiController(ReservationService reservationService, ReservationMappers reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ResponseEntity<Void> addReservation(ReservationDto body) {
        reservationService.addReservation(reservationMapper.reservationDtoToReservationEntity(body));
        return null;
    }

    @Override
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(reservationMapper.reservationEntityToReservationDto(reservationService.getAllReservations()));
    }

    @Override
    public ResponseEntity<ReservationDto> getReservationById(BigDecimal id) {
        return ResponseEntity.ok(reservationMapper.reservationEntityToReservationDto(reservationService.getReservationById(id.longValue())));
    }

    @Override
    public ResponseEntity<Void> removeReservation(BigDecimal id) {
        reservationService.removeReservation(id.longValue());
        return null;
    }

    @Override
    public ResponseEntity<List<ReservationDto>> searchReservations(BigDecimal id, BigDecimal userId, BigDecimal carId,
                                                                   org.threeten.bp.LocalDate fromDate, org.threeten.bp.LocalDate toDate,
                                                                   String pickUpLocation, String dropoffLocation) {
        return ResponseEntity.ok(reservationMapper.reservationEntityToReservationDto(reservationService.searchReservations(id.longValue(), userId.longValue(),
                carId.longValue(), fromDate, toDate, pickUpLocation, dropoffLocation)));
    }

    @Override
    public ResponseEntity<Void> updateReservation(BigDecimal id, ReservationDto body) {
        reservationService.updateReservation(id.longValue(), reservationMapper.reservationDtoToReservationEntity(body));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}