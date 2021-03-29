import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        ArrayList<Integer> intArr = new ArrayList<>();
        String[] inputs = in.nextLine().split(" ");
        for(String str : inputs)
            intArr.add(Integer.parseInt(str));
        int findInt = Integer.parseInt(in.nextLine());
        System.out.println(intArr.indexOf(findInt) >= 0 ? intArr.indexOf(findInt) : -1);
    }
}