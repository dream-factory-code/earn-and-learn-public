public class Main {
    public static void main(String[] args) {
        StringBuilder result = method(Integer.parseInt(args[0]));
        System.out.println(result.toString());
    }

    private static StringBuilder method(Integer n) {
        StringBuilder result = new StringBuilder();

        for(Integer i = 1; i <= n; i++) {
            if(i % 3 == 0) result.append("fizz");
            if(i % 5 == 0) result.append("buzz");
            if((i % 3 != 0) && (i % 5 != 0)) result.append(i.toString());
            result.append("\n");
        }

        return result;
    }
}
