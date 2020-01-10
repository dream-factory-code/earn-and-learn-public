package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BartolTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BartolTest.class);

    private CSVParser csvParser;
    List<User> allUsers;

    @Before
    public void setup() {
        csvParser = new CSVParser("./iranian-chicken.csv", new RemoteRandomGenerator());
        allUsers = csvParser.parse("./chicken-for-tests.csv");
    }

    @Test
    public void checkDate() {
        List<User> dates = allUsers.stream()
                .filter(t -> t.getDate().getDate() != null)
                .collect(Collectors.toList());

        Assert.assertTrue(dates.size() > 0);

    }

    @Test
    public void mapWomanNumberByCity() {
        Map<String, Long> womanNumberByCity = allUsers.stream()
                .filter(t -> "female".equals(t.getGender()))
                .collect(Collectors.groupingBy(t -> t.getLocation().getCity(), Collectors.counting()));

        Comparator<Map.Entry<String, Long>> womanCityComparator = Comparator.comparingLong(Map.Entry::getValue);

        LinkedHashMap<String, Long> sortedWomanNumberByCity = womanNumberByCity
                .entrySet()
                .stream()
                .sorted(womanCityComparator.reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x1, x2) -> x1, LinkedHashMap::new));

        sortedWomanNumberByCity.forEach((t1, t2) -> LOGGER.info(t1 + " " + t2));
    }
}