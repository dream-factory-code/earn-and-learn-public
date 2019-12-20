package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        //new CSVParser("chicken.csv", new RemoteRandomGenerator(10)).
        //        generateUsersAndSave();

        CSVParser csvParser = new CSVParser("chickens.csv",
                new RemoteRandomGenerator(10));

        csvParser.generateUsersAndSave(20);
    }

}
