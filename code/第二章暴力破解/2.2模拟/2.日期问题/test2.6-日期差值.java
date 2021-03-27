import java.util.Scanner;
public class Main {
    public static boolean isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
    public static int toDays(int year, int month, int day){
        int[] months = {0, 31, isLeapYear(year)? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1; i < month; i++)
            day += months[i];
        return day;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firYear = in.next();
        String secYear = in.next();
        int days = 0;
        int year1 = Integer.parseInt(firYear.substring(0,4));
        int year2 = Integer.parseInt(secYear.substring(0,4));
        for(int i = year1 ; i <= year2 - 1; i++)
            days += isLeapYear(i) ? 366 : 365;
        System.out.println(1 + days + toDays(year2, Integer.parseInt(secYear.substring(4,6)), Integer.parseInt(secYear.substring(6,8)))
                                - toDays(year2, Integer.parseInt(firYear.substring(4,6)), Integer.parseInt(firYear.substring(6,8))));
    }
}