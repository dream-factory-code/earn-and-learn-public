package hr.dreamfactory.lectures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Please provide a natural number");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);
            String output = fizBuz(n);
            LOGGER.info(output);
        } catch (NumberFormatException e) {
            LOGGER.error("Input is not number", e);
        }
    }

    public static String fizBuz(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            if (i % 3 == 0) {
                sb.append("fizz");
            }
            if (i % 5 == 0) {
                sb.append("buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                sb.append(i);
            }
            sb.append("\n");
//            if (i % 2 == 0) {
//                LOGGER.debug("iterated over:{}", i);
//            }
        }
        return sb.toString();
    }
}



