package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class KjezicTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KjezicTest.class);


    @Test
    public void iranTest() {
        CSVParser parser = new CSVParser("irans.csv", new RemoteRandomGenerator());
        List<User> iranUsers = parser.parse("chicken-for-tests.csv")
                .stream()
                .filter(t -> "IR".equals(t.getNationality()))
                .collect(Collectors.toList());
        parser.writeUsersToCSV(iranUsers);
    }

    @Test
    public void femalesInCity() {
        CSVParser parser = new CSVParser("females.csv", new RemoteRandomGenerator());
        List<User> users = parser.parse("chicken-for-tests.csv");

        Map<String, Long> females = users.stream()
                .filter(t -> "female".equals(t.getGender()))
                .collect(Collectors.groupingBy(t -> t.getLocation().getCity(), Collectors.counting()));

        Map<String, Long> femalesSorted = females.entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        femalesSorted.entrySet().forEach(t -> LOGGER.info("There are {} females in {}", t.getValue(), t.getKey()));
    }
}