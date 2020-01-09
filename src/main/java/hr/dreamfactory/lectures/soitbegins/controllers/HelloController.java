package hr.dreamfactory.lectures.soitbegins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/test")
    public String index() {
        return "Greetings from Test Spring Boot!";
    }
}
