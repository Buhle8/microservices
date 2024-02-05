package za.co.protogen.adapter;

import com.example.reservationsService.models.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.protogen.persistance.models.Reservation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMappers {

    ReservationMappers RESERVATION = Mappers.getMapper(ReservationMappers.class);

    Reservation reservationDtoToReservationEntity(ReservationDto reservationDto);

    List<ReservationDto> reservationEntityToReservationDto(List<Reservation> reservation);

    ReservationDto reservationEntityToReservationDto(Reservation reservation);

}