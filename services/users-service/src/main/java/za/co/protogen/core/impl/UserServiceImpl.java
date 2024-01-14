package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.UserService;
import za.co.protogen.persistance.models.User;
import za.co.protogen.persistance.repository.UserRepository;

import org.threeten.bp.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository ;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user)  ;
    }

    @Override
    public void removeUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalStateException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        if (existingUser != null){
            existingUser.setId(updatedUser.getId());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
            existingUser.setRsaId(updatedUser.getRsaId());
        }

    }

    @Override
    public List<User> searchUsers(Long id, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
        return getAllUsers().stream().filter(user -> user.getId().equals(id)||user.getFirstName().equalsIgnoreCase(firstName)||
                user.getLastName().equalsIgnoreCase(lastName)|| user.getDateOfBirth().equals(dateOfBirth)||
                user.getRsaId().equalsIgnoreCase(rsaId)).collect(Collectors.toList());
    }

}
