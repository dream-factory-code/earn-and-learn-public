package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.UserRepository;

import java.util.List;

public class HomeworkMain {

    private final hr.dreamfactory.lectures.homework1.CSVService CSVService = new CSVService();

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        CSVService csvService = new CSVService();
        List randomUsers = repository.getRandomUsers();
        csvService.writeToCSV(csvService.serializeUsers(randomUsers), "./geese.csv");
    }



}