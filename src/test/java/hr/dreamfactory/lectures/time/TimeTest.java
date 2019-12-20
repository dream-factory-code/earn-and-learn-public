package hr.dreamfactory.lectures.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeTest {

    @Test
    public void instants(){
        Instant now = Instant.now();
        Instant plus = now.plus(50, ChronoUnit.DAYS)
                            .plusNanos(200_325);

        System.out.println(now.toString());
        System.out.println(plus.toString());

        Duration between = Duration.between(now, plus);

        System.out.println(between);
    }


    @Test
    public void instants_ToLocalDate(){
        Instant now = Instant.now();

        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime.now();

        ZonedDateTime cet = ZonedDateTime.ofInstant(now, ZoneId.of("Europe/Zagreb"));

        ZonedDateTime timeIn10Months = cet.plus(10, ChronoUnit.MONTHS);
        ZonedDateTime truncateHours = timeIn10Months.truncatedTo(ChronoUnit.HOURS);
        ZonedDateTime truncateDays = timeIn10Months.truncatedTo(ChronoUnit.DAYS);


        System.out.println(timeIn10Months);
        System.out.println(truncateHours);
        System.out.println(truncateDays);
        System.out.println(        truncateDays.toLocalDateTime());

    }
}
