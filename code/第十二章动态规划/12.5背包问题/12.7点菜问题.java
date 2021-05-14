import java.util.Scanner;
public class Main{
    public static int getMaxValue(int[] weight, int[] value, int C, int N){
        int[] dp = new int[C + 1];
        for(int i = 0; i < N; i++){
            for(int j = C; j >= weight[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
        return dp[C];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int C = in.nextInt();
            int N = in.nextInt();
            int[] weight = new int[N];
            int[] value = new int[N];
            for(int i = 0; i < N; i++){
                weight[i] = in.nextInt();
                value[i] = in.nextInt();
            }
            System.out.println(getMaxValue(weight, value, C, N));
        }
    }
}