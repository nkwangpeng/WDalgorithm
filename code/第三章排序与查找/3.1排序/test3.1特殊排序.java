import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.math.*;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        ArrayList<Integer> nums = new ArrayList<>();
        String[] strs = in.nextLine().split(" ");
        int maxNum = 0;
        for(int i = 0; i < count; i++){
            nums.add(Integer.parseInt(strs[i]));
            maxNum = Math.max(maxNum, Integer.parseInt(strs[i]));
        }
        Collections.sort(nums);
        Iterator<Integer> iter = nums.iterator();
        System.out.println(maxNum);
        while(iter.hasNext())
            if(iter.next() == maxNum){
                iter.remove();
                break;
            }
        if(nums.size() == 0){
            System.out.println(-1);
            return;
        }
        for(int num : nums)
            System.out.print(num + " ");
    }
}