import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] person = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            person[i] = in.nextInt();
            if(map.get(person[i]) == null)
                map.put(person[i], 1);
            else
                map.put(person[i], map.get(person[i]) + 1);
        }
        for(int i = 0; i < N; i++)
            if(map.get(person[i]) > 1)
                System.out.println(map.get(person[i]) - 1);
            else
                System.out.println("BeiJu");
    }
}