package za.co.protogen.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistance.models.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByColor(String color);

    List<Car> findByYear(Integer year);

    List<Car> findByMake(String make);
}
