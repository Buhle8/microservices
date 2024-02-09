package za.co.protogen.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class ResourceServerConfigurerAdapter {
    public abstract void configure(HttpSecurity http) throws Exception;
}
