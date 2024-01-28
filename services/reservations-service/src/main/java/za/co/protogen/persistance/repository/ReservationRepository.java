package za.co.protogen.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.persistance.models.Reservation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
}

