public class Main {

    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            specialPrint(n);
        } catch (Exception e) {
            System.out.println("Error. Number is not provided");
        }
    }

    public static void specialPrint(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i <= n; i++){
            if (i%15==0) {
                sb.append("fizzbuzz\n");
            } else if (i%5==0) {
                sb.append("fizz\n");
            } else if (i%3==0) {
                sb.append("buzz\n");
            } else {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}


