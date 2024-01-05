package za.co.protogen.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.persistance.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
