package hr.dreamfactory.lectures.homework1;

import com.google.gson.JsonObject;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeworkMain {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {

        RandomUserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me");

        JsonObject jsonObject = api.getUsers("10");

        System.out.println(jsonObject.get("results").getAsJsonArray());

    }

    // will change from MockUser to UserModel
    public static void writeToCSV(String listMockUsers) {
        if (listMockUsers == null || listMockUsers.equals("List of users is empty.")) {
            LOGGER.error("Something went wrong, string shouldn't be empty.");
            System.exit(1);
        }
        String filePath = "./geese.csv";
        File csvfile = new File(filePath);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(csvfile));
            String[] header = {"fullname", "location"};
            bfw.write(header[0] + ", " + header[1]);
            bfw.newLine();
            bfw.write(listMockUsers);
            bfw.close();
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }


}