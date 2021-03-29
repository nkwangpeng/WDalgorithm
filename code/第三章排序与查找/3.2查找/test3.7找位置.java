import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    static char[] chArr = null;
    public static boolean isDump(char ch){
        if(ch == '*')
            return false;
        int num = 0;
        for(int i = 0; i < chArr.length; i++){
            if(chArr[i] == ch)
                num++;
            if(num == 2)
                return true;
        }
        return false;
    }
    public static void printDump(char ch){
        String res = "";
        for(int i = 0; i < chArr.length; i++){
            if(chArr[i] == ch){
                chArr[i] = '*';
                res += (ch + ":" + i + ",");
            }
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        chArr = str.toCharArray();
        for(int i = 0; i < chArr.length; i++){
            if(isDump(chArr[i])){
                printDump(chArr[i]);
            }
        }
    }
}