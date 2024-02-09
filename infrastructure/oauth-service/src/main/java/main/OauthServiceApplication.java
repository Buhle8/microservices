package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.protogen.security.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer

public class OauthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthServiceApplication.class, args);}

}
