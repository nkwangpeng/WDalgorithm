import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            int fromRadix = Integer.parseInt(strs[0]);
            int toRadix = Integer.parseInt(strs[1]);
            char[] nums = in.nextLine().toCharArray();
            int numsLen = nums.length;
            long tenRadixVslue = 0;
            for(int i = 0; i < numsLen; i++){
                if(nums[i] >= '0' && nums[i] <= '9')
                    tenRadixVslue += (nums[i] - '0') * Math.pow(fromRadix, numsLen - i - 1);
                else
                    tenRadixVslue += (nums[i] - 'A' + 10) * Math.pow(fromRadix, numsLen - i - 1);
            }
            String res = "";
            while(tenRadixVslue != 0){
                res += (tenRadixVslue % toRadix) <= 9 ? tenRadixVslue % toRadix : 'a' + ((tenRadixVslue % toRadix) - 10);
                tenRadixVslue /= toRadix;
            }
            System.out.println(new StringBuilder(res).reverse());
        }
    }
}