import java.util.Arrays;
import java.util.Scanner;
public class Main{
    private static int N;
    private static int[] weight;
    private static int[] value;
    private static final int inf = (int)1e9;
    public static int getMinMoney(int Capcity){
        int[] dp = new int[Capcity + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = weight[i]; j <= Capcity; j++){
                dp[j] = Math.min(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[Capcity];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int Capcity = -(in.nextInt() - in.nextInt());
            N = in.nextInt();
            weight = new int[N];
            value = new int[N];
            for(int j = 0; j < N; j++){
                value[j] = in.nextInt();
                weight[j] = in.nextInt();
            }
            int res = getMinMoney(Capcity);
            System.out.println(res == inf ? "This is impossible." : "The minimum amount of money in the piggy-bank is " + res + ".");
        }
    }
}