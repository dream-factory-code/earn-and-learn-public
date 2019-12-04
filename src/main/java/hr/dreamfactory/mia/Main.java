package hr.dreamfactory.mia;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("argument not provided");
            System.exit(1);
        }
        try{
            int n = (Integer.parseInt(args[0]));
            String output = fizBuz(n);
            System.out.println(output);
        }
        catch (NumberFormatException){
            System.out.println("number not provided");
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
            if (i != 15) {
                sb.append(i);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
