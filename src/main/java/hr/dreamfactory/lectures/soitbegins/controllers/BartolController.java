package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BartolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BartolController.class);

    @Autowired
    private UserRepository repository;

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        repository.create(user);
        LOGGER.info("Successfully created user!");
    }
}
