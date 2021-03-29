import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static ArrayList<Integer> intArr = new ArrayList<>();
    public static boolean isFound(int x){
        return intArr.indexOf(x) >= 0 ? true : false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String[] inputs = in.nextLine().split(" ");
        for(String str : inputs)
            intArr.add(Integer.parseInt(str));
        int findCount = Integer.parseInt(in.nextLine());
        String[] foundInt = in.nextLine().split(" ");
        for(String str : foundInt)
            System.out.println(isFound(Integer.parseInt(str)) == true ? "YES" : "NO");
    }
}