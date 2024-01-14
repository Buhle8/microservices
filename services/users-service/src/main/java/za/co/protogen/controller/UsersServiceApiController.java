package za.co.protogen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.Mappers;
import za.co.protogen.controller.api.UsersApi;
import za.co.protogen.controller.models.UserDto;
import za.co.protogen.core.UserService;
import za.co.protogen.persistance.models.User;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping
public class UsersServiceApiController implements UsersApi {
    private final UserService userService;
    private final Mappers userMappers;
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceApiController.class);
    public UsersServiceApiController(UserService userService, Mappers userMappers) {
        this.userService = userService;
        this.userMappers = userMappers;
    }


    @Override
    public ResponseEntity<Void> addUser(UserDto body) {
        userService.addUser(userMappers.userDtoToUserEntity(body));
        logger.info("adding user");
        return null;
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.info("getting all users");
        return ResponseEntity.ok(userMappers.userEntityToUserDto(userService.getAllUsers()));
    }

    @Override
    public ResponseEntity<UserDto> getUserById(BigDecimal id) {
        logger.info("getting user by id " + id);
        return ResponseEntity.ok(userMappers.userEntityToUserDto(userService.getUserById(id.longValue())));
    }

    @Override
    public ResponseEntity<Void> removeUser(BigDecimal id) {
        userService.removeUser(id.longValue());
        logger.info("removing user by id" + id);
        return null;
    }

    @Override
    public ResponseEntity<List<UserDto>> searchUsers(BigDecimal id, String firstName, String lastName, org.threeten.bp.LocalDate dateOfBirth, String rsaId) {
        logger.info("searching all users");
        return ResponseEntity.ok(userMappers.userEntityToUserDto(userService.searchUsers(id.longValue(),firstName,lastName,dateOfBirth,rsaId)));
    }

    @Override
    public ResponseEntity<Void> updateUser(BigDecimal id, UserDto body) {
        userService.updateUser(id.longValue(),userMappers.userDtoToUserEntity(body));
        logger.info("updating user");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

