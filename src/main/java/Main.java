public class Main {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i <= n; i++){
            if (i%15==0) {
                sb.append("fizzbuzz\n");
            } else if (i%5==0) {
                sb.append("fizz\n");
            } else if (i%3==0) {
                sb.append("buzz\n");
            } else {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
