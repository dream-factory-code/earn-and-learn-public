package hr.dreamfactory.lectures.homework1.controllers;


import hr.dreamfactory.lectures.homework1.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.homework1.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CSVParserTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVParserTest.class);

    @Test
    public void smoke(){
        Assert.assertTrue(true);
        CSVParser parser = new CSVParser("chicken-me.csv", new RemoteRandomGenerator());
        List<User> parse = parser.parse("chicken-for-tests.csv");
        Assert.assertTrue("We need over 20000", parse.size() > 20_000 - 1);
    }

    @Test
    public void groupByNations(){
        CSVParser parser = new CSVParser("chicken-me.csv", new RemoteRandomGenerator());
        List<User> parse = parser.parse("chicken-for-tests.csv");

        Map<String, Long> nationalities = parse.stream()
                .collect(Collectors.groupingBy(User::getNationality, Collectors.counting()));

        Map<String, Long> sorted = nationalities.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey
                        , entry -> entry.getValue(),
                        (e1, e2) -> e1, LinkedHashMap::new)
                );

        sorted.entrySet()
                .forEach(
                t -> LOGGER.info("Country {}. User Count: {}", t.getKey(), t.getValue())
        );
    }


    @Test
    public void duplicates(){
        CSVParser parser = new CSVParser("chicken-me.csv", new RemoteRandomGenerator());
        List<User> parse = parser.parse("chicken-for-tests.csv");

        BinaryOperator<User> selectFirst = (e1, e2) -> e2;
        Comparator<User> comparator = Comparator.comparing(x -> x.getName().getFirst());

        Map<String, User> sorted = parse
                .stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toMap(User::getNationality, t -> t,
                        selectFirst, LinkedHashMap::new)
                );

        sorted.entrySet()
                .forEach(
                        t -> LOGGER.info("Country {}. User Count: {}", t.getKey(), t.getValue().getName().getFirst())

                );
    }
}