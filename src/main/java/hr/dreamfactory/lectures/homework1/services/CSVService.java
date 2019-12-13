package hr.dreamfactory.lectures.homework1.services;

import hr.dreamfactory.lectures.homework1.model.common.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class CSVService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVService.class);

    public void writeToCSVFile(Path path, List<? extends User> users) {
        File file = path.toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file, true), StandardCharsets.UTF_8))) {

            if (file.exists() && path.toFile().length() == 0) {
                bufferedWriter.write("fullname, location");
            }

            for (User user : users) {
                bufferedWriter.newLine();
                bufferedWriter.write(serializeToCSV(user));
            }

        } catch (FileNotFoundException e) {
            LOGGER.error("Error writing to file", e);
        } catch (IOException e) {
            LOGGER.error("Error writing to file", e);
        }
    }

    public String serializeToCSV(User user) {
        return "\"" + user.fullName() + "\", \"" + user.location() + "\"";
    }
}