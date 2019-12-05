package hr.dreamfactory.lectures.llendel;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No prameters given.");
            System.exit(1);
        }

        try {
            String result = fizzBuzz(Integer.parseInt(args[0]));
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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
        }

        return result.toString();
    }


}
