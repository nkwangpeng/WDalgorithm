import java.util.Scanner;
public class Main{
    /*
    开n次方可以使用Math.pow()
    */
    public static int getRes(int m, int n){
        if(m <= n){
            return 1 + getRes(m * 2, n) + getRes(m * 2 + 1, n);
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            if(str.equals("0 0")) break;
            String[] strs = str.split(" ");
            int m = Integer.valueOf(strs[0]);
            int n = Integer.valueOf(strs[1]);
            System.out.println(getRes(m, n));
        }
    }
}