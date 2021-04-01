import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            StringBuffer sb = new StringBuffer();
            int count =  in.nextInt();
            int startIndex = in.nextInt();
            int forCount = in.nextInt();
            if(count == 0 || startIndex == 0 || forCount == 0)
                break;
            ArrayList<Integer> ls = new ArrayList<>();
            for(int i = 1; i <= count; i++)
                ls.add(i);
            for(int i = 1; i < startIndex; i++){
                ls.add(ls.remove(0));
            }
            while(!ls.isEmpty()){
                for(int i = 1; i < forCount; i++){
                    ls.add(ls.remove(0));
                }
                sb.append(ls.get(0) + ",");
                ls.remove(0);
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }
}