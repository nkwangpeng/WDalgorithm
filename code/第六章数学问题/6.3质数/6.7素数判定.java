import java.math.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num <= 1){
            System.out.println("no");
            return;
        }
        double sqrNum = Math.sqrt(num);
        for(int i = 2; i <= sqrNum; i++){
            if(num % i == 0){
            System.out.println("no");
            return;
            }
        }
        System.out.println("yes");
    }
}