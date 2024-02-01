package za.co.protogen.domain.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.protogen.domain.restTemplate.Car;

@FeignClient(name = "carsservice")
public interface CarFeign {
    @GetMapping("/cars/vin/{vin}")
    Car getCarById(@PathVariable String vin);
}
