package hr.dreamfactory.lectures.homework1;

import com.sun.istack.internal.NotNull;
import hr.dreamfactory.lectures.homework1.model.UserMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HomeworkMain {

    private static String FIELD_ONE = "fullname";
    private static String FIELD_TWO = "location";

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {

    }

    public static void writeToCSVFile(@NotNull Path path, @NotNull List<UserMock> users) {
        if (users.size() == 0) {
            return;
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            bufferedWriter.write(FIELD_ONE + ", " + FIELD_TWO);
            bufferedWriter.newLine();

            for (UserMock user : users) {
                bufferedWriter.write(user.serializeToCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}
