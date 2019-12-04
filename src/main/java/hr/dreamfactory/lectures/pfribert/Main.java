package hr.dreamfactory.lectures.pfribert;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Parameter is empty.");
            System.exit(1);
        }
        int num = 0;
        try {
            num = parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Argument should be a number.");
        }
        System.out.println(fizzBuzzer(num));
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
        }
        
        return output.toString();
    }
}
