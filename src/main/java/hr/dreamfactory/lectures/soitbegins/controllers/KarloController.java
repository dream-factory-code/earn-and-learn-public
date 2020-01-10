package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KarloController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/users/country")
    public List<User> filterByCountry(@RequestParam String country){
        return repository.find(country);
    }
}
