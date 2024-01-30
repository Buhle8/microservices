package za.co.protogen.specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import za.co.protogen.persistance.models.Car;

import java.util.Collection;
import java.util.List;

public class CarSpecifications {

    public static Specification<Car> vinEquals(String vin) {
        return (root, query, criteriaBuilder) -> {
            if (vin != null) return criteriaBuilder.equal(root.get("vin"), vin);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> makeEquals(String make) {
        return (root, query, criteriaBuilder) -> {
            if (make != null) return criteriaBuilder.equal(root.get("make"), make);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> modelEquals(String model) {
        return (root, query, criteriaBuilder) -> {
            if (model != null) return criteriaBuilder.equal(root.get("model"), model);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> yearEquals(Integer year) {
        return (root, query, criteriaBuilder) -> {
            if (year != null) return criteriaBuilder.equal(root.get("year"), year);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> colorEquals(String color) {
        return (root, query, criteriaBuilder) -> {
            if (color != null) return criteriaBuilder.equal(root.get("color"), color);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> engineEquals(String engine) {
        return (root, query, criteriaBuilder) -> {
            if (engine != null) return criteriaBuilder.equal(root.get("engine"), engine);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> transmissionEquals(String transmission) {
        return (root, query, criteriaBuilder) -> {
            if (transmission != null) return criteriaBuilder.equal(root.get("transmission"), transmission);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> fuelTypeEquals(String fuelType) {
        return (root, query, criteriaBuilder) -> {
            if (fuelType != null) return criteriaBuilder.equal(root.get("fuelType"), fuelType);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> mileageEquals(Integer mileage) {
        return (root, query, criteriaBuilder) -> {
            if (mileage != null) return criteriaBuilder.equal(root.get("mileage"), mileage);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> priceEquals(Integer price) {
        return (root, query, criteriaBuilder) -> {
            if (price != null) return criteriaBuilder.equal(root.get("price"), price);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> ownerIdEquals(Integer ownerId) {
        return (root, query, criteriaBuilder) -> {
            if (ownerId != null) return criteriaBuilder.equal(root.get("ownerId"), ownerId);
            else return criteriaBuilder.or();
        };
    }

    public static Specification<Car> featuresContains(List<String> features) {
        return (root, query, criteriaBuilder) -> {
            if (features != null && !features.isEmpty()) {
                Predicate[] predicates = features.stream()
                        .map(feature -> criteriaBuilder.isMember(feature, root.get("features")))
                        .toArray(Predicate[]::new);

                return criteriaBuilder.or(predicates);
            } else {
                return criteriaBuilder.or();
            }
        };
    }
}


