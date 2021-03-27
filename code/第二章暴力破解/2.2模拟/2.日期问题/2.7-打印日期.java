import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Main {
    public static int isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return 29;
        return 28;
    }
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int days = in.nextInt();
        int[] months = {31, isLeapYear(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = 1;
        for(int i = 0; i < 12; i++){
            if(days > months[i]){
                month += 1;
                days -= months[i];
            }
            else
                break;
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date date = format1.parse(year + "-" + month + "-" + days);
        System.out.println(format1.format(date));
    }
}