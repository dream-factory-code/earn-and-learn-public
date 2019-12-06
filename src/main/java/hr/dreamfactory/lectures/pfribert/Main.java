package hr.dreamfactory.lectures.pfribert;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static java.lang.Integer.parseInt;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Parameter shouldn't be empty.");
            System.exit(1);
        }
        try {
            int num = parseInt(args[0]);
            String output = fizzBuzzer(num);
            LOGGER.info(output);
        } catch (NumberFormatException e) {
            LOGGER.error("Argument should be a number.", e);
        }
    }

    public static String fizzBuzzer(int n) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; ++i) {
            if (i % 15 == 0) {
                output.append("fizzbuzz");
            } else if (i % 3 == 0) {
                output.append("fizz");
            } else if (i % 5 == 0) {
                output.append("buzz");
            } else {
                output.append(i);
            }
            output.append("\n");
            if (i % 2 == 0){
                LOGGER.debug("Iterated over: {}", i);
            }
        }
        
        return output.toString();
    }
}
