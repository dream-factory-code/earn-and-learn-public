package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import hr.dreamfactory.lectures.soitbegins.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PetraTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PetraTest.class);

    @Test
    public void petra() {
         CSVParser csvParser = new CSVParser("iran.csv", new RemoteRandomGenerator(10));

         List<User> iran = csvParser.parse("chicken-for-tests.csv").stream()
                 .filter(t -> "IR".equals(t.getNationality()))
                 .collect(Collectors.toList());
         csvParser.writeUsersToCSV(iran);
    }

    @Test
    public void map() {
        CSVParser csvParser = new CSVParser("iran.csv", new RemoteRandomGenerator(10));
        Map<String, Long> nationalitiesCount = csvParser.parse("chicken-for-tests.csv").stream()
                .collect(Collectors.groupingBy(User::getNationality, Collectors.counting()));

    }


    @Test
    public void women() {
        CSVParser parser = new CSVParser("chicken.csv", new RemoteRandomGenerator(10));
        List<User> parse = parser.parse("chicken-for-tests.csv");

        Map<String, Long> women = parse.stream()
                .filter(t -> "female".equals(t.getGender()))
                .collect(Collectors.groupingBy(t -> t.getLocation().getCity(), Collectors.counting()));

        Map<String, Long> sortedWomen = women.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey
                        , Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        sortedWomen.forEach((key, value) -> LOGGER.info("City {}. Women Count: {}", key, value));
    }

}