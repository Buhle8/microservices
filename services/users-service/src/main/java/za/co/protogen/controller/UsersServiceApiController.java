package za.co.protogen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDate;
import za.co.protogen.adapter.UserMappers;
import za.co.protogen.controller.api.UsersApi;
import za.co.protogen.controller.models.UserDto;
import za.co.protogen.core.UserService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping
public class UsersServiceApiController implements UsersApi {
    private final UserService userService;
    private final UserMappers userMappers;
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceApiController.class);
    public UsersServiceApiController(UserService userService, UserMappers userMappers) {
        this.userService = userService;
        this.userMappers = userMappers;
    }


    @Override
    public ResponseEntity<Void> addUser(UserDto body) {
        userService.addUser(userMappers.userDtoToUserEntity(body));
        logger.info("adding user");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.info("getting all users");
        List<UserDto>userDtos=userMappers.userEntityToUserDto(userService.getAllUsers());
        return ResponseEntity.ok(userDtos);
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> searchUsers(BigDecimal id, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
        logger.info("searching all users");
        Long idValue = (id != null) ? id.longValue() : null;
        List<UserDto>userDtos =userMappers.userEntityToUserDto(userService.searchUsers(idValue,firstName,lastName,dateOfBirth,rsaId));
        return ResponseEntity.ok(userDtos);
    }

    @Override
    public ResponseEntity<Void> updateUser(BigDecimal id, UserDto body) {
        userService.updateUser(id.longValue(),userMappers.userDtoToUserEntity(body));
        logger.info("updating user");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

