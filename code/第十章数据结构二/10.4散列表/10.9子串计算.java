import java.util.Scanner;
import java.util.TreeMap;
/*
1、HashMap中元素是没有顺序的；TreeMap中所有元素都是有某一固定顺序的。
2、HashMap继承AbstractMap类，是基于hash表实现的；TreeMap继承SortedMap类，是基于红黑树实现的。
*/
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
        String str = in.nextLine();
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j <= str.length(); j++){
                String tmpStr = str.substring(i, j);
                if(map.containsKey(tmpStr))
                    map.put(tmpStr, map.get(tmpStr) + 1);
                else
                    map.put(tmpStr, 1);
            }
        }
        for(String str1 : map.keySet())
            if(map.get(str1) > 1)
                System.out.println(str1 + " " + map.get(str1));
    }
}