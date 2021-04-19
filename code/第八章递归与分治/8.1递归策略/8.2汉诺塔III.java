import java.util.*;
import java.io.*;
public class Main{
    /*
    普通汉诺塔的次数为f(x) = 2^x - 1;
    因为f(1) = 1; f(2) = 3; f(3) = f(2) + 1 + f(2); f(4) = f(3) + 1 + f(3).....依此类推得f(x + 1) = 2*f(x) + 1
    然而此题为变形得汉诺塔问题
    f(x + 1) = 3*f(x) + 2
    */
    public static long getRes(long n){
        if(n == 1) return 2;
        if(n == 2) return 8;
        return 3 * getRes(n - 1) + 2;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long n = in.nextLong();
            System.out.println(getRes(n));
        }
    }
}