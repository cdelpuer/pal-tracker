package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {


    private String message;

    public WelcomeController(@Value("${welcome.message}") String hello)
    {
        this.message = hello;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}