import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            if(N == 0) break;
            int[] nums = new int[N];
            int[] dp = new int[N];
            for(int i = 0; i < N; i++)
                nums[i] = in.nextInt();
            dp[0] = nums[0];
            int res = nums[0];
            int start = nums[0];
            int end = nums[0];
            int endIndex = 0;
            int minusLen = nums[0] >= 0 ? 0 : 1;
            for(int i = 1; i < N; i++){
                if(nums[i] < 0) minusLen++;
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                if(dp[i] > res){
                    res = dp[i];
                    endIndex = i;
                    end = nums[i];
                }
            }
            int sum = 0;
            for(int i = endIndex; i >= 0; i--){
                sum += nums[i];
                if(sum == res)
                    start = nums[i];
            }
            if(minusLen == N){
                res = 0;
                start = nums[0];
                end = nums[N - 1];
            }
            System.out.println(res + " " + start + " " + end);
        }
    }
}