package hr.dreamfactory.lectures.mario;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough arguments provided.");
            System.exit(1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            String output = specialPrint(n);
        } catch (NumberFormatException e) {
            System.out.println("Number is not provided");
        }
    }

    public static String specialPrint(int n) {
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
        }
        return output.toString();
    }
}


