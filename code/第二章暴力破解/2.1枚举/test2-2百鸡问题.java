import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int x = 0; x <= 100; x++){
            for(int y = 0; y <= 100-x; y++){
                int z = 100 - x - y;
                if(5 * x + 3 * y + (double)z / 3 <= n)
                    System.out.println("x=" + x + ",y=" + y + ",z=" + z);
            }
        }
    }
}