package hr.dreamfactory.lectures1.mario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzz {
    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzz.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Please provide a natural number.");
            System.exit(1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            String output = specialFizzBuzz(n);
            LOGGER.info(output);
        } catch (NumberFormatException e) {
            LOGGER.error("Input is not a number.", e);
        }
    }

    public static String specialFizzBuzz(int n) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                output.append("fizzbuzz");
            } else if (i % 5 == 0) {
                output.append("fizz");
            } else if (i % 3 == 0) {
                output.append("buzz");
            } else {
                output.append(i);
            }
            output.append("\n");
            if (i % 100 == 0) {
                LOGGER.debug("Iterated over: {}",i);
            }
        }
        return output.toString();
    }
}


