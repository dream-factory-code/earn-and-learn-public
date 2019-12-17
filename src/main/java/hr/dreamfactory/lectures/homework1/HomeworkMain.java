package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.controllers.CSVParser;
import hr.dreamfactory.lectures.homework1.api.RemoteRandomGenerator;

public class HomeworkMain {

    public static void main(String[] args) {
//        new UsersToCSV("chicken.csv", new RemoteRandomGenerator(10))
//                .serialize();

        new CSVParser("chicken.csv", new RemoteRandomGenerator(10)).serialize();
    }



}
