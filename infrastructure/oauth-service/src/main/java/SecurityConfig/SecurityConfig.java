package SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import za.co.protogen.security.ResourceServerConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatchers("/public/**").permitAll()
                .antMatchers("/users/create").authenticated()
                .antMatchers("/users/**", "/reservations/**", "/cars/**").authenticated();
    }
}
