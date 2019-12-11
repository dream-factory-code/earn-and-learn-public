package hr.dreamfactory.lectures.homework1;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.model.UserModel;
import hr.dreamfactory.lectures.homework1.model.UserRepository;
import hr.dreamfactory.lectures.homework1.model.UsersModel;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HomeworkMain {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        List<? extends User> randomUsers = repository.getRandomUsers();
        writeToCSV(serializeUsers(randomUsers));
    }

    public static String serializeUsers(List<? extends User> results) {
        return results.stream()
                .map(User::buildCSVString)
                .collect(Collectors.joining("\n"));
    }


    public static void writeToCSV(String listUsers) {
        if (listUsers == null || listUsers.equals("List of users is empty.")) {
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
            bfw.write(listUsers);
            bfw.close();
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }


}