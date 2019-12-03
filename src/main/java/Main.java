import static java.lang.Integer.parseInt;

public class Main {

    public static void main (String[] args){
        int num = parseInt(args[0]);
        divideable(num);
    }


    public static void divideable (int n) {
        StringBuilder print = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                print.append("fizzbuzz\n");
            } else if (i % 3 == 0) {
                print.append("buzz\n");
            } else if (i % 5 == 0) {
                print.append("fizz\n");
            } else {
                print.append(i +"\n");
            }
        }
        System.out.println(print);
    }
}
