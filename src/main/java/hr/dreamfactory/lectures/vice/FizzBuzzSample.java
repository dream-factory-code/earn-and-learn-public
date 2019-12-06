package hr.dreamfactory.lectures.vice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzzSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzSample.class);


    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Please provide a natural number ");
            System.exit(1);
        }

        try {
            int input = Integer.parseInt(args[0]);
            String output = listNumbers(input);
            LOGGER.info(output);
        } catch (NumberFormatException e) {
            LOGGER.error("Input is not a number.", e);
        }
    }

    public static String listNumbers(int n) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                output.append("fizzbuzz\n");
                continue;
            }

            if (i % 3 == 0) {
                output.append("fizz\n");
                continue;
            }

            if (i % 5 == 0) {
                output.append("buzz\n");
                continue;
            }
            output.append(i);
            output.append("\n");
            if(i % 2 == 0){
                LOGGER.debug("Iterated over: {}", i);
            }
        }
        return output.toString();
    }
}
