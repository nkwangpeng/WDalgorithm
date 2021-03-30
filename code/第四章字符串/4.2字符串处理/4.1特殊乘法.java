import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int res = 0;
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 0; j < strs[1].length(); j++)
                res += (strs[0].charAt(i) - '0') *  (strs[1].charAt(j) - '0');
        }
        System.out.println(res);
    }
}