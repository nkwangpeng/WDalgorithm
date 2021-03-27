import java.util.Scanner;
public class Main {
    public static int isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return 29;
        return 28;
    }
    public static int getDays(int month){
        if(month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        int res = 0;
        for(int i = 1; i < month; i++){
            if(i == 2)
                res += isLeapYear(year);
            else
                res += getDays(i);
        }
        System.out.println(res + day);
    }
}