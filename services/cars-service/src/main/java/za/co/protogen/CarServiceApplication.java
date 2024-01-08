package za.co.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "za.co.protogen.adapter")
public class CarServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }
}