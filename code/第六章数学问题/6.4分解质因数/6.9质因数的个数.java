import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
            int num = in.nextInt();
            int cnt = 0;
            for(int i = 2; i * i <= num; i++){
                while(num % i == 0){
                    num = num / i;
                    cnt++;
                }
            }
            System.out.println(num == 1 ? cnt : cnt + 1);
        }
    }
}