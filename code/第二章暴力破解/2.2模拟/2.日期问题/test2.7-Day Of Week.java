import java.util.Scanner;
import java.util.HashMap;
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
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int days = 0;
        HashMap<Object, Object> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
        map.put(0, "Sunday");
        map.put(1, "Monday");
        map.put(2, "Tuesday");
        map.put(3, "Wednesday");
        map.put(4, "Thursday");
        map.put(5, "Friday");
        map.put(6, "Saturday");
        int year = Integer.parseInt(strs[2]);
        int month = (int)map.get(strs[1]);
        for(int i = 1; i < Integer.parseInt(strs[2]); i++)
            days += isLeapYear(i) ? 366 : 365;
        System.out.println(map.get((days + toDays(year, month, Integer.parseInt(strs[0]))) % 7));
    }
}