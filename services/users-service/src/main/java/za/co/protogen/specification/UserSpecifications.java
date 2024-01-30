package za.co.protogen.specification;

import org.springframework.data.jpa.domain.Specification;
import za.co.protogen.persistance.models.User;

import org.threeten.bp.LocalDate;

public class UserSpecifications {

    public static Specification<User> idEquals(Long id) {
        return (root, query, criteriaBuilder) -> {
            if (id != null) return criteriaBuilder.equal(root.get("id"), id);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<User> firstNameEquals(String firstName) {
        return (root, query, criteriaBuilder) -> {
            if (firstName != null) return criteriaBuilder.equal(root.get("firstName"), firstName);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<User> lastNameEquals(String lastName) {
        return (root, query, criteriaBuilder) -> {
            if (lastName != null) return criteriaBuilder.equal(root.get("lastName"), lastName);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<User> dateOfBirthEquals(LocalDate dateOfBirth) {
        return (root, query, criteriaBuilder) -> {
            if (dateOfBirth != null) return criteriaBuilder.equal(root.get("dateOfBirth"), dateOfBirth);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<User> rsaIdEquals(String rsaId) {
        return (root, query, criteriaBuilder) -> {
            if (rsaId != null) return criteriaBuilder.equal(root.get("rsaId"), rsaId);
            else return criteriaBuilder.or();
        };
    }
}