import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        int[] nums = new int[count];
        String[] strs = in.nextLine().split(" ");
        for(int i = 0; i < count; i++)
            nums[i] = Integer.parseInt(strs[i]);
        Arrays.sort(nums);
        for(int num : nums)
            System.out.print(num + " ");
    }
}