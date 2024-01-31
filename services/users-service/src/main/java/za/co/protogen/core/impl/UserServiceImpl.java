package za.co.protogen.core.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;
import za.co.protogen.core.UserService;
import za.co.protogen.persistance.models.User;
import za.co.protogen.persistance.repository.UserRepository;
import za.co.protogen.specification.UserSpecifications;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("User not found");
        }
        userRepository.deleteById(id);
    }
    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new IllegalStateException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setId(updatedUser.getId());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
            existingUser.setRsaId(updatedUser.getRsaId());
        }
    }

    @Override
    public List<User> searchUsers(Long id, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
        Specification<User> spec = Specification
                .where(UserSpecifications.idEquals(id))
                .or(UserSpecifications.firstNameEquals(firstName))
                .or(UserSpecifications.lastNameEquals(lastName))
                .or(UserSpecifications.dateOfBirthEquals(dateOfBirth))
                .or(UserSpecifications.rsaIdEquals(rsaId));

        return userRepository.findAll(spec);
    }

}
