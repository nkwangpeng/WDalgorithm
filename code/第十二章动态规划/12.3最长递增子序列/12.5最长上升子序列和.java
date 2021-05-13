import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < N; i++){
            int max = -(int)1e6;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = nums[i] + ((max == -(int)1e6) ? 0 : max);
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }
}