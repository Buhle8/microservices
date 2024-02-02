package za.co.protogen.domain.feign;

import com.example.reservationsService.models.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.protogen.domain.restTemplate.User;

@FeignClient(name = "usersservice")
public interface UserFeign {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}
