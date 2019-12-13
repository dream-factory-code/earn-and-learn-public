package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.common.Users;
import hr.dreamfactory.lectures.homework1.model.mocks.UsersMock;
import hr.dreamfactory.lectures.homework1.services.CSVService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String FILE_PATH = "./ducks.csv";
    private static final String BASE_URL = "https://randomuser.me/";
    private static final Long NUM_OF_USERS = 10l;

    private static final CSVService service = new CSVService();

    public static void main(String[] args) {
        Users userRepository = new UsersMock();

        Path output = Paths.get(FILE_PATH);
        service.writeToCSVFile(output, ( userRepository).getRandomUsers());
    }


}
