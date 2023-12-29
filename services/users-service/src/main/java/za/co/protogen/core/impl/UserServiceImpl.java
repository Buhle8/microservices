package za.co.protogen.core.impl;

import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService  {
    private final List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
     users.add(user)  ;
    }

    @Override
    public void removeUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));

    }

    @Override
    public User getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
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
        return users.stream().filter(user -> user.getId().equals(id)||user.getFirstName().equalsIgnoreCase(firstName)||
                user.getLastName().equalsIgnoreCase(lastName)|| user.getDateOfBirth().equals(dateOfBirth)||
                user.getRsaId().equalsIgnoreCase(rsaId)).collect(Collectors.toList());
    }
}
