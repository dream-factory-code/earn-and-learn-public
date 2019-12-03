public class Main {

    public static void main(String[] args) {
        fizbuz(Integer.parseInt(args[0]));



    }

    public static void fizbuz(int x){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=x;i++){
            if(i%3==0)
                sb.append("fizz");
            if(i%5==0)
                sb.append("buzz");
            if(i%3!=0 && i%5!=0)
                sb.append(i);
            sb.append("\n");
            System.out.println(sb);
        }
    }
}
