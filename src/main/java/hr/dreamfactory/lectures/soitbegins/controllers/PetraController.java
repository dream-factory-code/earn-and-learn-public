package hr.dreamfactory.lectures.soitbegins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
public class PetraController {

    @RequestMapping("/")
    public String index() {
        return "Updated User";
    }
}
