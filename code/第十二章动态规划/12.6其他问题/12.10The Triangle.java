import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] dp = new int[N + 1];
        int[][] triangles = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++)
                triangles[i][j] = in.nextInt(); 
        }
        for(int i = 1; i <= N; i++){
            for(int j = i; j >= 1; j--)
                dp[j] = Math.max(dp[j], dp[j - 1]) + triangles[i][j];
        }
        int res = 0;
        for(int i = 1; i <= N; i++)
            res = Math.max(res, dp[i]);
        System.out.println(res);
    }
}