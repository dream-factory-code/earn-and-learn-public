public class Main {

    public static void main(String[] args) {
        Integer n = Integer.parseInt(args[0]);
        StringBuilder output = new StringBuilder();

        for(int i=1; i<=n; i++){
            if(i%3 == 0)
                output.append("fizz");
            if(i%5 == 0)
                output.append("buzz");
            if(i%5 != 0 & i%3 != 0)
                output.append(i);
            output.append("\n");
        }
        System.out.print(output);
    }
}
