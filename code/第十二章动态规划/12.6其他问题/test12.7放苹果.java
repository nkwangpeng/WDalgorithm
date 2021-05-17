import java.util.Scanner;
import java.util.Arrays;
/*
dp解法
参考链接：https://www.cnblogs.com/dccmmtop/p/5365190.html
1： 苹果的个数为1时 只有一种方法
2： 盘子的个数为1时 只有一种方法
3： 当i>=j是（苹果大于盘子） 第一 ：至少有一个盘子空着不放dp[i][j-1] 第二 ：每个盘子放一个苹果后还剩i-j
个苹果 再计算i-j个苹果放在j个盘子的情况 dp[i-j][j];
4： 当i<j时 盘子多了就相当于i个苹果放进i个盘子的情况dp[i][i];
*/
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] dp = new int[M + 1][N + 1];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= M; i++)
            for(int j = 1; j <= N; j++){
                if(i == 1 || j == 1)
                    dp[i][j] = 1;
                else{
                    if(j > i){
                        dp[i][j] = dp[i][i];
                    }
                    else{
                        dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                    }
                }
            }
        System.out.println(dp[M][N]);
    }
}