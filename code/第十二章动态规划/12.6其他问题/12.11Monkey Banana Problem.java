import java.util.Scanner;
public class Main{
    public static int getMaxBanana(int[][] bananas, int N){
        int r = 2 * N;
        int c = N + 1;
        int[] dp = new int[c];
        int res = 0;
        for(int i = 1; i < r; i++){
            for(int j = c - 1; j >= 1; j--){
                dp[j] = Math.max(dp[j - 1], dp[j]) + bananas[i][j];
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            int N = in.nextInt();
            int[] dp = new int[N + 1];
            int[][] bananas = new int[2 * N][N + 1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= i; j++)
                    bananas[i][j] = in.nextInt();
            }
            for(int i = 1; i < N; i++){
                for(int j = 1; j <= N - i; j++)
                    bananas[N + i][i + j] = in.nextInt();
            }
            System.out.println("Case " + t + ": " + getMaxBanana(bananas, N));
        }
    }
}