import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int num = in.nextInt();
            String res = "";
            while(num != 0){
                res += num % 8;
                num >>= 3;
            }
            System.out.println(new StringBuilder(res).reverse());
        }
    }
}