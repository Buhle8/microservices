package za.co.protogen.domain.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import za.co.protogen.domain.restTemplate.User;

@FeignClient(name = "user-service")
public interface UserFeign {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id, @RequestHeader("Authorization") String authorization);

}
