package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@RestController
public class PetraController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/update/{id}")
    public void update() {
        repository.update(id, user);
    }
}
