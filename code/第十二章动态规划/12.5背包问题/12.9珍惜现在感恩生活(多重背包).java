/*
多重背包可以将背包拆分为N个背包，转换为01背包问题
*/
import java.util.Arrays;
import java.util.Scanner;
public class Main{
    private static int[] weight = new int[2000];
    private static int[] value = new int[2000];
    private static final int inf = (int)1e9;
    public static int getMinMoney(int Capcity, int N){
        int[] dp = new int[Capcity + 1];
        for(int i = 0; i < N; i++){
            for(int j = Capcity; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[Capcity];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int Capcity = in.nextInt();
            int N = in.nextInt();
            int number = 0;
            for(int j = 0; j < N; j++){
                int riceWeight = in.nextInt();
                int riceValue = in.nextInt();
                int k = in.nextInt();
                for(int q = 0; q < k; q++){
                    weight[number] = riceWeight;
                    value[number++] = riceValue;
                }
            }
            System.out.println(getMinMoney(Capcity, number));
        }
    }
}