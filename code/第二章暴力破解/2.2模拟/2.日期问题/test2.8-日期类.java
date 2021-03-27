import java.util.Scanner;
public class Main {
    public static String intToString(int x){
        if(x < 10)
            return "0" + x;
        return "" + x;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        for(int i = 0; i < num; i++){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int day = Integer.parseInt(strs[2]);
            int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if(month == 12 && day == 31)
                System.out.println(year + 1 + "-01-01");
            else if(day == months[month])
                System.out.println(year + "-" + intToString(month + 1) + "-01");
            else
                System.out.println(year + "-" + intToString(month) + "-" + intToString(day + 1));
        }
    }
}