import java.util.Scanner;
public class Main {
    public static boolean isRelated7(int x){
        if(x % 7 == 0 || x / 10 == 7 || x % 10 == 7)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;
        for(int i = 0; i <= n; i++){
            if(!isRelated7(i))
                sum += i * i; 
        }
        System.out.println(sum);
    }
}