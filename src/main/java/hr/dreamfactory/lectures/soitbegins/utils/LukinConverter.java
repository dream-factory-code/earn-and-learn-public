package hr.dreamfactory.lectures.soitbegins.utils;

import com.univocity.parsers.conversions.Conversion;

import java.time.ZonedDateTime;

public class LukinConverter implements Conversion<String, ZonedDateTime> {

    @Override
    public ZonedDateTime execute(String s) {
        return ZonedDateTime.parse(s);
    }

    @Override
    public String revert(ZonedDateTime o) {
        return o.toString();
    }
}
