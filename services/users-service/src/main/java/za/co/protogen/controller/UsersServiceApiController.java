package za.co.protogen.controller;

import com.example.usersService.api.UsersApi;
import com.example.usersService.models.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.LocalDate;
import za.co.protogen.adapter.UserMappers;
import za.co.protogen.core.UserService;
import za.co.protogen.persistance.models.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
public class UsersServiceApiController implements UsersApi {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceApiController.class);


    public UsersServiceApiController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<Void> addUser(UserDto body) {
        userService.addUser(UserMappers.USER.userDtoToUserEntity(body));
        logger.info("adding user");

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.info("getting all users");

        List<UserDto> userDtos = UserMappers.USER.userEntityToUserDto(userService.getAllUsers());

        return ResponseEntity.ok(userDtos);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(BigDecimal id) {
        logger.info("getting user by id " + id);
        UserDto userDto = UserMappers.USER.userEntityToUserDto(userService.getUserById(id.longValue()));
        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<Void> removeUser(BigDecimal id) {
        userService.removeUser(id.longValue());
        logger.info("removing user by id" + id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Override
    public ResponseEntity<List<UserDto>> searchUsers(BigDecimal id, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
        logger.info("searching all users");
        Long idValue = (id != null) ? id.longValue() : null;
        List<UserDto> userDtos = UserMappers.USER.userEntityToUserDto(userService.searchUsers(idValue, firstName, lastName, dateOfBirth, rsaId));

        return ResponseEntity.ok(userDtos);
    }

    @Override
    public ResponseEntity<Void> updateUser(BigDecimal id, UserDto body) {
        userService.updateUser(id.longValue(), UserMappers.USER.userDtoToUserEntity(body));
        logger.info("updating user");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.addUser(user);
    }
        @GetMapping("/login")
        public String login() {
            return "login";
        }

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/refreshToken")
    public ResponseEntity<Map<String, String>> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(refreshToken);
      if (accessToken == null || accessToken.isExpired()) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
       }

        Object authentication = tokenStore.readAuthentication(refreshToken);

        TokenStore yourTokenService = new TokenStore();
        DefaultOAuth2AccessToken newAccessToken = yourTokenService.createAccessToken(authentication);

        Map<String, String> response = new HashMap<>();
        response.put("access_token", newAccessToken.getValue());
        response.put("token_type", "bearer");
        response.put("expires_in", String.valueOf(newAccessToken.getExpiresIn()));

        return ResponseEntity.ok(response);
    }
}



