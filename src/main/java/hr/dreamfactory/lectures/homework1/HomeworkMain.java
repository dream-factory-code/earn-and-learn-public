package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.controllers.UsersToCSV;
import hr.dreamfactory.lectures.homework1.model.FeignUsersRepository;

public class HomeworkMain {

    public static void main(String[] args) {
        new UsersToCSV("chicken.csv", new FeignUsersRepository(10))
                .serialize();
    }

}
