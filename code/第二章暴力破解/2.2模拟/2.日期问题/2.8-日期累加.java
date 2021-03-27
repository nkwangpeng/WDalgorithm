import java.util.Scanner;
public class Main {
    public static boolean isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
    public static int toDays(int year, int month, int day){
        int[] months = {0, 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1; i < month; i++)
            day += months[i];
        return day;
    }
    public static String intToString(int x){
        if(x >= 10)
            return "" + x;
        else
            return "0" + x;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for(int i = 0; i < num; i++){
            int year = input.nextInt();
            int month = input.nextInt();
            int day = input.nextInt();
            int daysPlus = input.nextInt() + toDays(year, month, day);
            int dayPerYear = isLeapYear(year) ? 366 : 365;
            while(daysPlus > dayPerYear){
                daysPlus -= dayPerYear;
                year++;
                dayPerYear = isLeapYear(year) ? 366 :365;
            }
            int[] months = {0, 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            month = 1;
            while(daysPlus > months[month]){
                daysPlus -= months[month];
                month++;
            }
            System.out.println(year + "-" + intToString(month) + "-" + intToString(daysPlus));
        }
    }
}