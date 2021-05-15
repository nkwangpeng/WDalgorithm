/*
01背包的变形，其中邮票面值等价于物品重量，邮票综合等价于背包容量，邮票个数等价于价值，且每个价值为1，求最低的价值即可。
*/
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static int getMinNum(int[] weight, int M, int N){
        int[] dp = new int[M + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = M; j >= weight[i]; j--){
                if(dp[j - weight[i]] != (int)1e9)
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
            }
        }
        return dp[M] == (int)1e9 ? 0 : dp[M];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int M = in.nextInt();
            int N = in.nextInt();
            int[] weight = new int[N];
            for(int i = 0; i < N; i++)
                weight[i] = in.nextInt();
            System.out.println(getMinNum(weight, M, N));
        }
    }
}