package hr.dreamfactory.lectures.kjezic;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Please provide natural number");
            System.exit(1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            LOGGER.info(fizzBuzz(n));
        } catch (NumberFormatException e) {
            LOGGER.error("Input is not a number.", e);
        }
    }

    public static String fizzBuzz(int n) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                LOGGER.debug("Iterated over {}", i);
                output.append("fizz");
            }
            if (i % 5 == 0) {
                output.append("buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                output.append(i);
            }

            output.append("\n");
        }
        return output.toString();
    }
}
