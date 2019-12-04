package hr.dreamfactory.lectures.llendel;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No prameters given.");
            System.exit(1);
        }

        try {
            StringBuilder result = fizzBuzzPrint(Integer.parseInt(args[0]));
            System.out.println(result.toString());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder fizzBuzzPrint(Integer n) {
        StringBuilder result = new StringBuilder();

        for (Integer i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                result.append("fizz");
            }

            if (i % 5 == 0) {
                result.append("buzz");
            }

            if (i % 15 != 0) {
                result.append(i.toString());
            }

            result.append("\n");
        }

        return result;
    }


}
