import java.util.Scanner;
import java.util.Arrays;
/*
dp[i]表示i拆分的个数
如果i=2*N+1，则拆分时一定会携带1，因此dp[i]=dp[i-1]
如果i=2*N,则分两种情况：
情况1：带1拆分，则有dp[i]=d[i-1]
情况2:不带1拆分，则此时拆分出来的数均为偶数，每一种拆分结果都除以2不会影响拆分的个数，因此dp[i] = dp[i/2];
初始化：dp[1] = 1;
*/
public class Main{
    private static int mod = 1000000000;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for(int i = 2; i <= N; i++)
            if((i & 1) == 1)
                dp[i] = dp[i - 1];
            else
                dp[i] = (dp[i-1] + dp[i / 2]) % mod;
        System.out.println(dp[N]);
    }
}