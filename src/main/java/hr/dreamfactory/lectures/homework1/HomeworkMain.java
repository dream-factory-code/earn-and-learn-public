package hr.dreamfactory.lectures.homework1;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;
import hr.dreamfactory.lectures.homework1.model.MockUser;
import org.slf4j.LoggerFactory;

import javax.ws.rs.HEAD;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HomeworkMain {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {

        RandomUserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me");

        JsonObject jsonObject = api.getUsers("10");

        System.out.println(jsonObject.get("results").getAsJsonArray());

    }

    public static void writeToCSV(List<MockUser> users) {
        String filePath = "./geese.csv";
        File csvfile = new File(filePath);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(csvfile));
            String[] header = {"fullname", "location"};
            bfw.write(header[0] + ", " + header[1]);
            bfw.newLine();

            for (User user : users) {
                bfw.write("\"" + user.fullName() + "\"" + ", " + "\"" + user.location() + "\"");
                bfw.newLine();
            }

            bfw.close();
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}