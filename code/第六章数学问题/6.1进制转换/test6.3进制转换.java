import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(Integer.parseInt(in.nextLine().substring(2), 16));
        }
    }
}