import java.util.Scanner;
public class Main{
    public static int calRes(char[] ch1s, char[] ch2s){
        if(ch1s.length == 0 || ch2s.length == 0)
            return 0;
        int ch1Len = ch1s.length, ch2Len = ch2s.length;
        int[][] dp = new int[ch1Len + 1][ch2Len + 1];
        for(int i = 0; i <= ch1Len; i++){
            for(int j = 0; j <= ch2Len; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else{
                    if(ch1s[i - 1] == ch2s[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ch1Len][ch2Len];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            System.out.println(calRes(strs[0].toCharArray(), strs[1].toCharArray()));
        }
    }
}