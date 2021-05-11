import java.util.Scanner;
/*dp[n] = dp[n-1] + dp[n-2];*/
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N  = in.nextInt();
        int[] dp = new int[100];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println(dp[N]);
    }
}
/*
//dfs
import java.util.Scanner;
public class Main{
    private static int N;
    private static int res;
    private static int[] path;
    private static int cnt;
    public static void dfs(int n){
        if(n == N){
            res++;
            for(int i = 0; i < cnt; i++){
                if(i == 0)
                    System.out.print(path[0]);
                else
                    System.out.print("-" + path[i]);
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= 2; i++){
            if(n + i <= N){
                path[cnt++] = i;
                dfs(n + i);
                cnt--;
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N  = in.nextInt();
        res = 0;
        cnt = 0;
        path = new int[100];
        dfs(0);
        System.out.println(res);
    }
}
*/