package hr.dreamfactory.lectures.soitbegins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
