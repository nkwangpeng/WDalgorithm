import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.*;
import java.util.Arrays;
public class Main{
    public static int dd(int a, int b){
        if(b == 0)
            return a;
        return dd(b, a % b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("0")) break;
            int count = Integer.parseInt(line);
            int[] nums = new int[count];
            String[] strs = br.readLine().split(" ");
            int res = 0;
            for(int i = 0; i < count; i++) nums[i] = Integer.parseInt(strs[i]);
            for(int i = 0; i< count - 1; i++){
                for(int j = i + 1; j < count; j++)
                    if(dd(nums[i], nums[j]) == 1)
                        res++;
            }
            System.out.println(res);
        }
    }
}