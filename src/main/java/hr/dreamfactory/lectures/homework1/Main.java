package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.api.UserRepository;
import hr.dreamfactory.lectures.homework1.api.HttpRepository;
import hr.dreamfactory.lectures.homework1.model.common.Users;
import hr.dreamfactory.lectures.homework1.services.CSVService;
import hr.dreamfactory.lectures.homework1.services.UnivocityCSVService;

public class Main {
    private static final String FILE_PATH = "./ducks.csv";
    private static final String BASE_URL = "https://randomuser.me/";
    private static final Long NUM_OF_USERS = 10l;

    private static final CSVService service = new CSVService();
    private static final UnivocityCSVService univocityCSVService = new UnivocityCSVService();

    public static void main(String[] args) {
        Users userRepository = new UserRepository(BASE_URL, NUM_OF_USERS);
        try {
            HttpRepository httpRep = new HttpRepository(BASE_URL, NUM_OF_USERS);
            univocityCSVService.writeToCSV(FILE_PATH, httpRep.getRandomUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Path output = Paths.get(FILE_PATH);
        //service.writeToCSVFile(output, ( userRepository).getRandomUsers());
    }
}
