import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map1 = new HashMap<>();
        while(in.hasNext()){
            String str = in.nextLine();
            if(str.equals("@END@"))
                break;
            int spaceIndex = str.indexOf("]") + 1;
            map.put(str.substring(0, spaceIndex), str.substring(spaceIndex + 1));
            map1.put(str.substring(spaceIndex + 1), str.substring(1, spaceIndex - 1));
        }
        int n = Integer.valueOf(in.nextLine());
        for(int i = 0; i < n; i++){
            String str = in.nextLine();
            if(map.containsKey(str))
                System.out.println(map.get(str));
            else if(map1.containsKey(str))
                System.out.println(map1.get(str));
            else
                System.out.println("what?");
        }
    }
}