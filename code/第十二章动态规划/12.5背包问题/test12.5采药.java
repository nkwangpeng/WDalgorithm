import java.util.Scanner;
public class Main{
    public static int getMaxValue(int[] weight, int[] value, int T, int M){
        int[] dp = new int[T + 1];
        for(int i = 0; i < M; i++){
            for(int j = T; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[T];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int M = in.nextInt();
        int[] weight= new int[M];
        int[] value = new int[M];
        for(int i = 0; i < M; i++){
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        System.out.println(getMaxValue(weight, value, T, M));
    }
}