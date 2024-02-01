package za.co.protogen.adapter;


import org.mapstruct.Mapper;
import com.example.carsService.models.CarDto;
import org.mapstruct.factory.Mappers;
import za.co.protogen.persistance.models.Car;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMappers {
    CarMappers CAR = Mappers.getMapper(CarMappers.class);
    CarDto carEntityToCarDto(Car car);
    List<CarDto> carEntityToCarDto(List<Car> car);
    Car carDtoToCarEntity(CarDto carDto);
}
