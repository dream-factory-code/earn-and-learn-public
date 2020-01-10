package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Test Spring Boot!";
    }

    @RequestMapping("/users")
    public List<User> users() {
        return repository.getUsers(10);
    }

    @RequestMapping("/users/{id}")
    public List<User> users(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }
}
