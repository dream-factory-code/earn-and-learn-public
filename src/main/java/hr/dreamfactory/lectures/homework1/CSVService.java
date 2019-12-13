package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.common.User;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVService {
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CSVService.class);

    public String serializeUsers(List<? extends User> results) {
        return results
                .stream()
                .map(User::buildCSVString)
                .collect(Collectors.joining("\n"));
    }

    public void writeToCSV(String listUsers, String filePath) {
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