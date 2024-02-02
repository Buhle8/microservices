package za.co.protogen.adapter;

import com.example.reservationsService.models.CarDto;
import com.example.reservationsService.models.ReservationDto;
import com.example.reservationsService.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.protogen.domain.restTemplate.Car;
import za.co.protogen.domain.restTemplate.User;
import za.co.protogen.persistance.models.Reservation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMappers {

    ReservationMappers RESERVATION = Mappers.getMapper(ReservationMappers.class);

    Reservation reservationDtoToReservationEntity(ReservationDto reservationDto);

    List<ReservationDto> reservationEntityToReservationDto(List<Reservation> reservation);

    ReservationDto reservationEntityToReservationDto(Reservation reservation);

    CarDto carEntityToCarDto(Car car);

    UserDto userEntityToUserDto(User user);
}