import java.util.Scanner;

public class Main{
    public static boolean isMatch(char c1, char c2){
        if(c1 <= 'Z' && c1 >='A') {
            c1 += 'a' - 'A';
        }
        if(c2 <= 'Z' && c2 >= 'A') {
            c2 += 'a' - 'A';
        }
        return (c1 == c2);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String[] strs = new String[count];
        for(int i = 0; i < count; i++){
            strs[i] = in.nextLine();
        }
        String patStr = in.nextLine().toLowerCase();
        for(int i = 0; i < count; i++){
            String tmpStr = strs[i].toLowerCase();
            int j = 0, k = 0;
            for(; j < tmpStr.length() && k < patStr.length(); j++, k++){
                if(patStr.charAt(k) =='[') {
                    //在[]中找到匹配
                    while(patStr.charAt(++k) !=']') {
                        if(isMatch(tmpStr.charAt(j), patStr.charAt(k))) {
                            break;
                        }
                    }
                    if(patStr.charAt(k) ==']') {
                        break;
                    }
                    //匹配之后找到]
                    while(patStr.charAt(k)!=']') {
                        k++;
                    }
                } else {
                    if(!isMatch(tmpStr.charAt(j), patStr.charAt(k))) {
                        break;
                    }
                }
            }
            if(j == tmpStr.length() && k== patStr.length()) {
                System.out.println(i + 1 + " " + strs[i]);
            }
        }
    }
}