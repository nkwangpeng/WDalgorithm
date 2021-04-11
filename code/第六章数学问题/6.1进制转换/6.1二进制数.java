import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            StringBuilder res = new StringBuilder();
            while(num != 0){
                res.append(num % 2);
                num = num / 2 ;
            }
            System.out.println(res.reverse().toString());
        }
    }
}