package hr.dreamfactory.lectures.soitbegins.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime> {
    @Override
    public void write(JsonWriter jsonWriter, ZonedDateTime zonedDateTime) throws IOException {
        jsonWriter.value(zonedDateTime.toString());
    }

    @Override
    public ZonedDateTime read(JsonReader jsonReader) throws IOException {
        return ZonedDateTime.parse(jsonReader.nextString());
    }


    public static Gson createTimeZoneGson(){
        return new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
                .create();
    }
}
