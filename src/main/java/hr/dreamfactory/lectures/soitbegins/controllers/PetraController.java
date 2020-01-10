package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PetraController {

    @Autowired
    private UserRepository repository;

    @PostMapping("users/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody User user) {
        repository.update(id, user);
    }
}
