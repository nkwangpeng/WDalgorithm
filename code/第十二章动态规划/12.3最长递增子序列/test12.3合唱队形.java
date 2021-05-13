import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        int[] dpPre = new int[N];
        int[] dpPost = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = in.nextInt();
        dpPre[0] = 1;
        dpPost[N - 1] = 1;
        int res = 1;
        for(int i = 1; i < N; i++){
            dpPre[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dpPre[i] = Math.max(dpPre[i], dpPre[j] + 1);
            }
        }
        for(int i = N - 2; i >= 0; i--){
            dpPost[i] = 1;
            for(int j = N - 1; j > i; j--){
                if(nums[i] > nums[j])
                    dpPost[i] = Math.max(dpPost[i], dpPost[j] + 1);
            }
        }
        for(int i = 0; i < N; i++)
                res = Math.max(res, dpPre[i] + dpPost[i] - 1);
        System.out.println(N - res);
    }
}