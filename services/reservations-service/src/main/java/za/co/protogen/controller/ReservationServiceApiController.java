package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistance.Reservation;
import za.co.protogen.domain.restTemplate.Car;
import za.co.protogen.domain.restTemplate.User;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationServiceApiController {
    private final ReservationService reservationService;
    RestTemplate restTemplate = new RestTemplate();



    @Autowired
    public ReservationServiceApiController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);

    }

    @DeleteMapping("/{id}")
    public void removeReservationById(@PathVariable Long id) {
        reservationService.removeReservation(id);

    }

    @PutMapping("/{id}")
    public void updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);

    }
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return restTemplate.getForObject("http://localhost:9101/users/" + userId, User.class);
    }

    @GetMapping("/car/{carId}")
    public Car getCarById(@PathVariable Long carId) {
        return restTemplate.getForObject("http://localhost:9102/cars/" + carId, Car.class);
    }

    @GetMapping("/searchReservations")
    public List<Reservation> searchReservations(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "userId", required = false)Long userId,
            @RequestParam(name = "carId", required = false) Long carId,
            @RequestParam(name = "fromDate", required = false) LocalDate fromDate,
            @RequestParam(name = "toDate", required = false) LocalDate toDate,
            @RequestParam(name = "pickUpLocation", required = false) String pickUpLocation,
            @RequestParam(name = "dropOffLocation", required = false) String dropOffLocation
    ){
        return reservationService.searchReservations(id, userId, carId, fromDate,toDate,pickUpLocation,dropOffLocation);
    }
}
