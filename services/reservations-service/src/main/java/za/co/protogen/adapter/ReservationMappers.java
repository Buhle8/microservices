package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import za.co.protogen.controller.models.ReservationDto;
import za.co.protogen.persistance.models.Reservation;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface ReservationMappers {
    Reservation reservationDtoToReservationEntity(ReservationDto reservationDto);
    List<ReservationDto> reservationEntityToReservationDto(List<Reservation> reservation);
    ReservationDto reservationEntityToReservationDto(Reservation reservation);
}
