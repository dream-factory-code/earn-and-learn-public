package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.controllers.CSVParser;
import hr.dreamfactory.lectures.homework1.model.ApacheUsersRepository;

public class HomeworkMain {

    public static void main(String[] args) {
//        new UsersToCSV("chicken.csv", new FeignUsersRepository(10))
//                .serialize();

        new CSVParser("chicken.csv", new ApacheUsersRepository(10)).serialize();
    }



}
