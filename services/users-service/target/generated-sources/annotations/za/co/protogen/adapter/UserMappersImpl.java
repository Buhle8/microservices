package za.co.protogen.adapter;

import com.example.usersService.models.UserDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import za.co.protogen.persistance.models.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-31T22:09:38+0000",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMappersImpl implements UserMappers {

    @Override
    public User userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        if ( userDto.getId() != null ) {
            user.setId( userDto.getId().longValue() );
        }
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setDateOfBirth( userDto.getDateOfBirth() );
        user.setRsaId( userDto.getRsaId() );

        return user;
    }

    @Override
    public List<UserDto> userEntityToUserDto(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( user.size() );
        for ( User user1 : user ) {
            list.add( userEntityToUserDto( user1 ) );
        }

        return list;
    }

    @Override
    public UserDto userEntityToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getId() != null ) {
            userDto.setId( BigDecimal.valueOf( user.getId() ) );
        }
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setDateOfBirth( user.getDateOfBirth() );
        userDto.setRsaId( user.getRsaId() );

        return userDto;
    }
}
