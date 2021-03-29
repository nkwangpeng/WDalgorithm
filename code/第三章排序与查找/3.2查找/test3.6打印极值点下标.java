import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String[] inStrs = in.nextLine().split(" ");
        int[] inNums = new int[count];
        for(int i = 0; i < count; i++)
            inNums[i] = Integer.parseInt(inStrs[i]);
        System.out.print(inNums[0] == inNums[1] ? "" : 0 + " ");
        for(int i = 1; i < count - 1; i++){
            if(inNums[i - 1] < inNums[i] && inNums[i] > inNums[i + 1] || inNums[i - 1] > inNums[i] && inNums[i] < inNums[i + 1])
                System.out.print(i + " ");
        }
        System.out.println(inNums[count - 1] == inNums[count - 2] ? "" : count - 1 + " ");
    }
}