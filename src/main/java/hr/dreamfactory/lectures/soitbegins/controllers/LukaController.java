package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LukaController {
    @Autowired
    private UserRepository repository;

    @DeleteMapping("/users")
    private void delete(@RequestParam Integer id) {
        repository.delete(id);
    }

}
