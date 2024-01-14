package za.co.protogen.adapter;


import org.mapstruct.Mapper;
import za.co.protogen.controller.models.CarDto;
import za.co.protogen.persistance.models.Car;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMappers {
    CarDto carEntityToCarDto(Car car);
    List<CarDto> carEntityToCarDto(List<Car> car);
    Car carDtoToCarEntity(CarDto carDto);
}
