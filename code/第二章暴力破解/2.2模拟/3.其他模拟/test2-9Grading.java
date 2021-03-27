import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int T = in.nextInt();
        int G1 = in.nextInt();
        int G2 = in.nextInt();
        int G3 = in.nextInt();
        int GJ = in.nextInt();
        if(Math.abs(G1 - G2) <= T)
            System.out.println((double)(G1 + G2) / 2);
        else if(Math.abs(G1 - G3) <= T && Math.abs(G2 - G3) <= T)
            System.out.println(Math.max(G1, Math.max(G2, G3)));
        else if(Math.abs(G1 - G3) <= T || Math.abs(G2 - G3) <= T)
            System.out.println(Math.abs(G1 - G3) < Math.abs(G2 - G3) ? (double)(G1 + G3) / 2 : (double)(G2 + G3) / 2);
        else
            System.out.println(GJ);
    }
}