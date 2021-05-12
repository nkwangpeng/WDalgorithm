/*
将矩阵“折叠”为一维数组
*/
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    private static int N;
    private static int[][] matrix;
    public static int[] compressMatrix(int i, int j){
        int[] res = new int[N];
        Arrays.fill(res, 0);
        for(int p = i; p <= j; p++){
            for(int q = 0; q < N; q++)
                res[q] += matrix[p][q];
        }
        return res;
    }
    public static int getMaxConsequence(int[] nums){
        int[] dp = new int[N];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static int GetMaxSubMatrix(){
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                int[] nums = compressMatrix(i, j);
                res = Math.max(res, getMaxConsequence(nums));
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            matrix = new int[N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    matrix[i][j] = in.nextInt();
            System.out.println(GetMaxSubMatrix());
        }
    }
}