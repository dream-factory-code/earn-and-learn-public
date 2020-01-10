package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.UserRepository;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KarloController {

    @Autowired
    private UserRepository repository;

    public List<User> filterByCountry(String country){
        return repository.find(country);
    }
}
