package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PetraController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id, User user) {
        repository.update(id, user);
    }
}
