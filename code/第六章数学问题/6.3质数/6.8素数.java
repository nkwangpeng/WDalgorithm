import java.math.*;
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    private static boolean[] isPrime = new boolean[10000];
    private static int[] prime = new int[10000];
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        Arrays.fill(isPrime, true);
        for(int i = 2; i < n ; i++){
            if(isPrime[i]) {
                if(i % 10 == 1) sb.append(" ").append(i);
                prime[cnt++] = i; 
            }
            for(int j = 0; j < cnt & (i * prime[j]) < n; j++){
                isPrime[i * prime[j]] = false;
                if(i % prime[j] == 0) break;
            }
        }
        System.out.println(sb.length() == 0 ? "-1" : sb.substring(1));
    }
}