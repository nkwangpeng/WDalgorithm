import java.util.Scanner;
public class Main {
    public static char getPwd(char ch){
        if(!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'))
            return ch;
        if(ch == 'z')
            return 'a';
        if(ch == 'Z')
            return 'A';
        return (char)(ch + 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String res = "";
        for(int i = 0; i < str.length(); i++)
            res += str.charAt(i) == ' ' ? ' ' : getPwd(str.charAt(i));
        System.out.println(res);
    }
}