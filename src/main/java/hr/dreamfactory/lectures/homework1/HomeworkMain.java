package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.MockUser;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HomeworkMain {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {

    }

    public static void writeToCSV(List<MockUser> users) {
        String filePath = "./geese.csv";
        File csvfile = new File(filePath);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(csvfile));
            String[] header = { "fullname", "location"};
            bfw.write(header[0] + ", " + header[1]);
            bfw.newLine();

            for (MockUser user : users) {
                bfw.write(user.serializeUserToCSV());
                bfw.newLine();
            }

            bfw.close();
        }
        catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}
