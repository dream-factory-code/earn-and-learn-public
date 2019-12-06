package hr.dreamfactory.lectures.vice;

public class FizzBuzzSample {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide some input.");
            System.exit(1);
        }

        try {
            int input = Integer.parseInt(args[0]);
            String output = listNumbers(input);
            System.out.println(output);
        } catch (NumberFormatException e) {
            System.out.println("Number is not provided.");
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
        }
        return output.toString();
    }
}