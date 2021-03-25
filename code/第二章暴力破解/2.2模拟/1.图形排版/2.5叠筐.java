import java.io.IOException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n == 1 || n == 2)
            throw new IOException("n should be larger than 2");
        char firCh = input.next().charAt(0);
        char secCh = input.next().charAt(0);
        char[][] Matrix = new char[n][n];
        for(int i = 0; i < n; i++){
            char ch = (i % 2 == 0) ? secCh : firCh;
            for(int j = i; j < n - i; j++){
                Matrix[i][j] = Matrix[j][i] = Matrix[n - i - 1][j] = Matrix[j][n - i - 1] = ch;
            }
        }
        Matrix[0][0] = Matrix[0][n - 1] = Matrix[n - 1][0] = Matrix[n - 1][n - 1] = ' ';
        for(char[]row : Matrix){
            for(char ch : row)
            System.out.print(ch);
            System.out.println();
        }
    }
}