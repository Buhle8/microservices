package za.co.protogen.specification;

import org.springframework.data.jpa.domain.Specification;
import org.threeten.bp.LocalDate;
import za.co.protogen.persistance.models.Reservation;

public class ReservationSpecifications {
    public static Specification<Reservation> idEquals(Long id) {
        return (root, query, criteriaBuilder) -> {
            if (id != null) return criteriaBuilder.equal(root.get("id"), id);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> userIdEquals(Long userId) {
        return (root, query, criteriaBuilder) -> {
            if (userId != null) return criteriaBuilder.equal(root.get("userId"), userId);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> carIdEquals(Long carId) {
        return (root, query, criteriaBuilder) -> {
            if (carId != null) return criteriaBuilder.equal(root.get("carId"), carId);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> dateFrom(LocalDate fromDate) {
        return (root, query, criteriaBuilder) -> {
            if (fromDate != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("fromDate"), fromDate);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> dateTo( LocalDate toDate) {
        return (root, query, criteriaBuilder) -> {
            if (toDate != null) return criteriaBuilder.lessThanOrEqualTo(root.get("toDate"), toDate);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> pickUpLocationEquals(String pickUpLocation) {
        return (root, query, criteriaBuilder) -> {
            if (pickUpLocation != null) return criteriaBuilder.equal(root.get("pickUpLocation"), pickUpLocation);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    public static Specification<Reservation> dropOffLocationEquals(String dropOffLocation) {
        return (root, query, criteriaBuilder) -> {
            if (dropOffLocation != null) return criteriaBuilder.equal(root.get("dropOffLocation"), dropOffLocation);
            else return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

}
