public class Main {

    public static void main(String[] args) {
        try{
            int input = Integer.parseInt(args[0]);
            customPrint(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Number is not provided.");
        }
    }

    public static void customPrint(int n) {
        StringBuilder output = new StringBuilder();

        for(int i = 1; i <=n; i++) {
            if(i%15 == 0) {
                output.append("fizzbuzz\n") ;
                continue;
            }

            if(i%3 == 0) {
                output.append("fizz\n");
                continue;
            }

            if(i%5 == 0) {
                output.append("buzz\n");
                continue;
            }
            output.append(i);
            output.append("\n");
        }
        System.out.println(output);
    }
}
