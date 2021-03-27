import java.util.Scanner;
import java.util.HashMap;
public class Main {
    public static int getTimes(char x){
        int[] times = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};
        int asciiNum = (int)x;
        return times[asciiNum -97];
    }
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('a', 1);
        hashMap.put('b', 1);
        hashMap.put('c', 1);
        hashMap.put('d', 2);
        hashMap.put('e', 2);
        hashMap.put('f', 2);
        hashMap.put('g', 3);
        hashMap.put('h', 3);
        hashMap.put('i', 3);
        hashMap.put('j', 4);
        hashMap.put('k', 4);
        hashMap.put('l', 4);
        hashMap.put('m', 5);
        hashMap.put('n', 5);
        hashMap.put('o', 5);
        hashMap.put('p', 6);
        hashMap.put('q', 6);
        hashMap.put('r', 6);
        hashMap.put('s', 6);
        hashMap.put('t', 7);
        hashMap.put('u', 7);
        hashMap.put('v', 7);
        hashMap.put('w', 8);
        hashMap.put('x', 8);
        hashMap.put('y', 8);
        hashMap.put('z', 8);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chs = str.toCharArray();
        int res = getTimes(chs[0]);
        for(int i = 1; i < chs.length; i++){
            res += getTimes(chs[i]);
            if(hashMap.get(chs[i]) == hashMap.get(chs[i - 1]))
                res += 2;
        }
        System.out.println(res);
    }
}