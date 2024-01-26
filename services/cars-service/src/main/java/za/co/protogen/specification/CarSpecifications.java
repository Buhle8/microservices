package za.co.protogen.specification;

import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;
import za.co.protogen.persistance.models.Car;

import java.util.Collection;
import java.util.List;

public class CarSpecifications {

    public static Specification<Car> vinEquals(String vin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("vin"), vin);
    }

    public static Specification<Car> makeEquals(String make) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("make"), make);
    }

    public static Specification<Car> modelEquals(String model) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("model"), model);
    }

    public static Specification<Car> yearEquals(Integer year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
    }

    public static Specification<Car> colorEquals(String color) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("color"), color);
    }

    public static Specification<Car> engineEquals(String engine) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("engine"), engine);
    }

    public static Specification<Car> transmissionEquals(String transmission) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("transmission"), transmission);
    }

    public static Specification<Car> fuelTypeEquals(String fuelType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("fuelType"), fuelType);
    }

    public static Specification<Car> mileageEquals(Integer mileage) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("mileage"), mileage);
    }

    public static Specification<Car> priceEquals(Integer price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("price"), price);
    }

    public static Specification<Car> ownerIdEquals(Integer ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("ownerId"), ownerId);
    }

    public static Specification<Car> featuresContains(List<String> feature) {
        return (root, query, criteriaBuilder) -> {
            if (feature != null && !feature.isEmpty()) {
                Expression<Collection<String>> featuresExpression = root.get("features");
                Expression<String> featureToCheck = criteriaBuilder.literal(feature.get(0));
                return criteriaBuilder.isMember(featureToCheck, (Expression<? extends Collection<String>>) featuresExpression);
            } else {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
        };
    }

}


