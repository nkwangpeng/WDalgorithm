import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            if(num == 0)
                break;
            int stepNum = 0;
            while(true){
                if(num == 1){
                    System.out.println(stepNum);
                    break;
                }
                num = (num % 2 == 0) ? num / 2 : (3 * num + 1) / 2;
                stepNum++;
            }
        }
    }
}