package za.co.protogen.adapter;

import com.example.usersService.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.protogen.persistance.models.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMappers {

    UserMappers USER = Mappers.getMapper(UserMappers.class);
    User userDtoToUserEntity(UserDto userDto);
    List<UserDto> userEntityToUserDto(List<User> user);
    UserDto userEntityToUserDto(User user);
}


