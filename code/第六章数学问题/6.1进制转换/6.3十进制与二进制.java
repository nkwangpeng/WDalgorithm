import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            BigInteger bigInt = new BigInteger(str ,10);
            String tmpStr = new StringBuilder(bigInt.toString(2)).reverse().toString();
            bigInt = new BigInteger(tmpStr, 2);
            System.out.println(bigInt.toString());
        }
    }
}