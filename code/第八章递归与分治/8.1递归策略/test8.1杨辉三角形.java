import java.util.Scanner;
public class Main{
    public static int triAngle(int i, int j){
        if(i == j || j == 0) return 1;
        return triAngle(i - 1, j - 1) + triAngle(i - 1, j);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++)
                System.out.print(triAngle(i, j) + " ");
            System.out.println();
        }
    }
}