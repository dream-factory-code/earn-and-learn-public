package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@RestController
public class LukaController {

    @Autowired
    private UserRepository repository;

    @DeleteMapping("/users/{id}")
    private void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

}
