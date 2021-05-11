import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            long[] nums = new long[N];
            long res = Long.MIN_VALUE;
            for(int i = 0; i < N; i++){
                if(i == 0){
                    nums[0] = in.nextLong();
                    res = nums[0];
                }
                else{
                    long inNum = in.nextLong();
                    nums[i] = Math.max(inNum, inNum + nums[i - 1]);
                    res = Math.max(res, nums[i]);
                }
            }
            System.out.println(res);
        }
    }
}