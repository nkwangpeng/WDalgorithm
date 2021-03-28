import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class MyComparator implements Comparator<Integer> {
    @Override //作用是检查下面的方法名是不是父类中所有的，也起到注释的作用
    public int compare(Integer a, Integer b) {
        return a < b ? 1 : -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        Integer[] oddNums = new Integer[10];
        int[] evenNums = new int[10];
        Arrays.fill(oddNums, -1);
        Arrays.fill(evenNums, -1);
        String[] strs = in.nextLine().split(" ");
        for(int i = 0; i < 10; i++){
            int inNum = Integer.parseInt(strs[i]);
            if(inNum % 2 == 0)
                evenNums[i] = inNum;
            else
                oddNums[i] = inNum;
        }
        Arrays.sort(evenNums);
        Arrays.sort(oddNums, new MyComparator());
        for(int num : oddNums)
            if(num != -1)
                System.out.print(num + " ");
        for(int num : evenNums)
            if(num != -1)
                System.out.print(num + " ");
    }
}