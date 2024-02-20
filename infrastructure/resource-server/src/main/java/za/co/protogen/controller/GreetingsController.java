package za.co.protogen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.service.GreetingsService;

import java.util.Map;

@RestController
public class GreetingsController {

    private final GreetingsService greetingsService;

    GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/")
    Map<String, String> hello() {
        return greetingsService.greet();
    }
}
