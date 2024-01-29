package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.protogen.controller.models.UserDto;
import za.co.protogen.persistance.models.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMappers {

    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    User userDtoToUserEntity(UserDto userDto);
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    List<UserDto> userEntityToUserDto(List<User> user);
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    UserDto userEntityToUserDto(User user);
}
