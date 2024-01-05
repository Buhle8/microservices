package za.co.protogen.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.persistance.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long > {
}
