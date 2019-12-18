package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.controllers.CSVParser;
import hr.dreamfactory.lectures.homework1.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.homework1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HomeworkMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        //new CSVParser("chicken.csv", new RemoteRandomGenerator(10)).
        //        generateUsersAndSave();

        CSVParser csvParser = new CSVParser("chicken-for-tests.csv",
                new RemoteRandomGenerator(1000));

        csvParser.generateUsersAndSave(20);


    }



}
