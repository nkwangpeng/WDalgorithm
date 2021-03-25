import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int turkeyNum = input.nextInt();
        int firstNum = input.nextInt();
        int midNum = input.nextInt();
        int lastNum = input.nextInt();
        int midSum = firstNum * 1000 + midNum * 100 + lastNum * 10;
        for(int i = 9; i > 0; i--){
            for(int j = 9; j >= 0; j--){
                int sum = i * 10000 + midSum + j;
                if(sum % turkeyNum ==0){
                    System.out.println(i + " " + j + " " + sum / turkeyNum);
                    return;
                }
            }
        }
       System.out.println(0);
    }
}