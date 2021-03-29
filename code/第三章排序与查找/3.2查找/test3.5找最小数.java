import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = Integer.parseInt(in.nextLine());
            int inX = Integer.MAX_VALUE, inY = 0;
            for(int i = 0; i < count; i++){
                String[] inNums = in.nextLine().split(" ");
                int tmpX = Integer.parseInt(inNums[0]);
                if(tmpX < inX){
                    inX = tmpX;
                    inY = Integer.parseInt(inNums[1]);
                }
                else if(tmpX == inX)
                    inY = Math.min(inY, Integer.parseInt(inNums[1]));
            }
            System.out.println(inX + " " + inY);
        }
    }
}