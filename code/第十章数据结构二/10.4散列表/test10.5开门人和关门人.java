import java.util.Scanner;
import java.util.HashMap;
/*
时间比较大小也相当于字符串比较大小
*/
public class Main{
    private static int[] res = new int[101];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String opener = null;
        String closer = null;
        String endTime = "00:00:00";
        String startTime = "23:59:59";
        int N = Integer.parseInt(in.nextLine());
        for(int i = 0; i < N; i++){
            String[] strs = in.nextLine().split(" ");
            if(startTime.compareTo(strs[1]) > 0){
                opener = strs[0];
                startTime = strs[1];
            }
            if(endTime.compareTo(strs[2]) < 0){
                closer = strs[0];
                endTime = strs[2];
            }
        }
        System.out.println(opener + " " + closer);
    }
}