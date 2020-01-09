package hr.dreamfactory.lectures.soitbegins.controllers;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CSVLukaParserTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVLukaParserTest.class);

    @Test
    @Ignore
    public void iranianChickenTest() {
        CSVParser parser = new CSVParser("iranian-chicken.csv", new RemoteRandomGenerator());

        List<User> users = parser.parse("chicken-for-tests.csv");

        List<User> iranians = users.stream()
                .filter(t -> "IR".equals(t.getNationality()))
                .collect(Collectors.toList());

        parser.writeUsersToCSV(iranians);
    }

    @Test
    @Ignore
    public void groupingByTest() {
        CSVParser parser = new CSVParser("nation-count.csv", new RemoteRandomGenerator());

        List<User> users = parser.parse("chicken-for-tests.csv");
        Comparator<Map.Entry<String, Long>> filter = Comparator.comparing(Map.Entry::getValue);

        Map<String, Long> nationalities = users
                .stream()
                .filter(t -> "female".equals(t.getGender()))
                .collect(Collectors.groupingBy(t -> t.getLocation().getCity(), Collectors.counting()));

        Map<String, Long> sorted = nationalities.entrySet()
                .stream()
                .sorted(filter.reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sorted.entrySet().forEach(
                t -> LOGGER.info("City {}, Count {}", t.getKey(), t.getValue())
        );
    }

}