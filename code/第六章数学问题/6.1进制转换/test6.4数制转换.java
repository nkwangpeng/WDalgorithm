import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            System.out.println(Long.toString(Long.parseLong(strs[1], Integer.parseInt(strs[0])), Integer.parseInt(strs[2])).toUpperCase());
        }
    }
}