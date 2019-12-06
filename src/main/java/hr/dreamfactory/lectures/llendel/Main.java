package hr.dreamfactory.lectures.llendel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("No arguments provided, please provide a natural number.");
            System.exit(1);
        }

        try {
            String result = fizzBuzz(Integer.parseInt(args[0]));
            LOGGER.info(result);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Input is not a number", e);
        }
    }

    public static String fizzBuzz(Integer n) {
        StringBuilder result = new StringBuilder();

        for (Integer i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                result.append("fizz");
            }
            if (i % 5 == 0) {
                result.append("buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                result.append(i.toString());
            }

            result.append("\n");

            if (i % 2 == 0) {
                LOGGER.debug("Iterated over: {}", i);
            }
        }

        return result.toString();
    }


}
