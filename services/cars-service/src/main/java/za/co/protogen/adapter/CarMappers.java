package za.co.protogen.adapter;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import za.co.protogen.controller.models.CarDto;
import za.co.protogen.persistance.models.Car;

import java.util.List;

@Mapper
@Component
public interface CarMappers {
    CarDto carEntityToCarDto(Car car);
    List<CarDto> carEntityToCarDto(List<Car> car);
    Car carDtoToCarEntity(CarDto carDto);
}
