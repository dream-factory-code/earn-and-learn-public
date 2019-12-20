package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.homework1.controllers.CSVParser;
import hr.dreamfactory.lectures.homework1.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Burek3000Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Burek3000Test.class);

    @Test
    public void womenNumberInCity(){

        List<User> allUsers = new CSVParser("chicken-for-tests.csv", new RemoteRandomGenerator()).parse();

        Map<String, Long> womenInCity = allUsers.stream()
                .filter(t -> t.getGender().equals("female"))
                .collect(Collectors.groupingBy(t -> t.getLocation().getCity(), Collectors.counting()));

        Map<String, Long> sortedWomen = womenInCity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2 ) -> a1, LinkedHashMap::new));

        sortedWomen.entrySet().forEach(t -> LOGGER.info("City: {}. Women Count: {}", t.getKey(), t.getValue()));

    }
}
