import java.util.Scanner;
public class Main{
    public static void helper(int n, StringBuilder sb){
        String str = Integer.toBinaryString(n);
        int lstIndex = 0;
        for(int i = str.length() - 1; i >=  0; i--){
            if(str.charAt(i) != '0'){
                lstIndex = i;
                break;
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '0'){
                int pow = str.length() - i - 1;
                sb.append("2");
                if(pow == 0)
                    sb.append("(0)");
                else if(pow == 1)
                    ;
                else if(pow == 2)
                    sb.append("(2)");
                else{
                    sb.append("(");
                    helper(pow, sb);
                    sb.append(")");
                }
                if(i != lstIndex)
                    sb.append("+");
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = Integer.valueOf(in.nextLine());
            StringBuilder sb = new StringBuilder();
            helper(n, sb);
            System.out.println(sb);
        }
    }
}