package hr.dreamfactory.lectures.soitbegins.utils;


import com.google.gson.Gson;
import hr.dreamfactory.lectures.soitbegins.model.users.DateOfBirth;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedDateTimeAdapterTest {

    @Test(expected = RuntimeException.class)
    public void testNoAdapter_Exception(){
        DateOfBirth birth = createDateOfBirth();

        Gson gson = new Gson();

        String json = gson.toJson(birth);
        DateOfBirth reserializeBirth = gson.fromJson(json, DateOfBirth.class);
    }

    @Test
    public void testWithAdapter(){
        DateOfBirth birth = createDateOfBirth();

        Gson gson = ZonedDateTimeAdapter.createTimeZoneGson();

        String json = gson.toJson(birth);
        DateOfBirth reserializeBirth = gson.fromJson(json, DateOfBirth.class);
        Assert.assertNotNull(reserializeBirth);
    }

    private DateOfBirth createDateOfBirth() {
        ZonedDateTime timeOfBirth = ZonedDateTime.now().minus(33, ChronoUnit.YEARS);
        long age = ChronoUnit.YEARS.between(timeOfBirth, ZonedDateTime.now());

        DateOfBirth birth = new DateOfBirth();
        birth.setDate(timeOfBirth);
        birth.setAge(String.valueOf(age));
        return birth;
    }

}