import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            if(str.equals("0")) break;
            String[] strs = str.split(" ");
            int radix = Integer.parseInt(strs[0]);
            long num1 = Integer.parseInt(strs[1]);
            long sum = num1 + Integer.parseInt(strs[2]);
            String res = "";
            while(sum != 0){
                res = sum % radix + res;
                sum /= radix;
            }
            System.out.println(res.isEmpty() ? "0" : res);
        }
    }
}