import java.math.*;
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    private static boolean[] isPrime = new boolean[200000];
    private static int[] prime = new int[10000];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        int i = 2;
        Arrays.fill(isPrime, true);
        while(true){
            if(isPrime[i]) {
                prime[cnt++] = i; 
            }
            if(cnt == n){
                System.out.println(prime[cnt - 1]);
                return;
            }
            for(int j = 0; j < cnt & (i * prime[j]) < isPrime.length; j++){
                isPrime[i * prime[j]] = false;
                if(i % prime[j] == 0) break;
            }
            i++;
        }
    }
}