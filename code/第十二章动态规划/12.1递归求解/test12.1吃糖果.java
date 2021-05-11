import java.util.Scanner;
/*dp[n] = dp[n-1] + dp[n-2];*/
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N  = in.nextInt();
        int[] dp = new int[100];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println(dp[N]);
    }
}