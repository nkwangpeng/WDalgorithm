import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[] missiles = new int[N];
            for(int i = 0; i < N; i++)
                missiles[i] = in.nextInt();
            int[] dp = new int[N];
            int res = 1;
            dp[0] = 1;
            for(int i = 1; i < N; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(missiles[j] >= missiles[i])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
            System.out.println(res);
        }
    }
}