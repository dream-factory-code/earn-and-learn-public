package hr.dreamfactory.lectures.kjezic;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Input arguments");
            System.exit(1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            System.out.println(fizzBuzz(n));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static String fizzBuzz(int n) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                output.append("fizz");
            }
            if (i % 5 == 0) {
                output.append("buzz");
            }
            if (i % 15 != 0) {
                output.append(i);
            }

            output.append("\n");
        }
        return output.toString();
    }
}
