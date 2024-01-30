package za.co.protogen.adapter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import za.co.protogen.controller.models.UserDto;
import za.co.protogen.persistance.models.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T23:50:53+0000",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMappersImpl implements UserMappers {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public User userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        if ( userDto.getDateOfBirth() != null ) {
            user.setDateOfBirth( LocalDate.parse( userDto.getDateOfBirth(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        if ( userDto.getId() != null ) {
            user.setId( userDto.getId().longValue() );
        }
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
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

        if ( user.getDateOfBirth() != null ) {
            userDto.setDateOfBirth( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getDateOfBirth() ) );
        }
        if ( user.getId() != null ) {
            userDto.setId( BigDecimal.valueOf( user.getId() ) );
        }
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setRsaId( user.getRsaId() );

        return userDto;
    }
}
