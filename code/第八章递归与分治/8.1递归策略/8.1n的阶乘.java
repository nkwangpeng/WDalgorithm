import java.util.*;
public class Main{
    public static long getRes(long n){
        if(n == 1) return 1;
        return n * getRes(n - 1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(getRes(n));
    }
}