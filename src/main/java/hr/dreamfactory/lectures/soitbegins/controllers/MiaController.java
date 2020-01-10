package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MiaController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/users/paginate")
    public List<User> users(@RequestParam int limit,@RequestParam int offset) {
        return repository.skipAndLimit(limit,offset);
    }

    @RequestMapping("/users/save")
    public void save() {
        repository.writeToCSV();
    }

}
