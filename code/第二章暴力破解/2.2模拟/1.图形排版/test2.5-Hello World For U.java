import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int len = str.length();
        int n1 = (len + 2) / 3;
        int n2 = len - 2 * n1 + 2;
        for(int i = 0; i < n1 - 1; i++){
            System.out.print(str.charAt(i));
            for(int j = 1; j < n2 - 1; j++)
                System.out.print(' ');
            System.out.print(str.charAt(len - i -1) + "\n");
        }
        for(int i =0; i < n2; i++)
            System.out.print(str.charAt(n1 + i - 1));
    }
}