import java.util.Scanner;
import java.util.HashMap;
public class Main{
    private static int[] res = new int[101];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        while(in.hasNext()){
            int N = in.nextInt();
            if(N == 0)
                break;
            for(int i = 0; i < N; i++){
                int score = in.nextInt();
                if(map.containsKey(score))
                    map.put(score, map.get(score) + 1);
                else
                    map.put(score, 1);
            }
            int findScore = in.nextInt();
            System.out.println(map.get(findScore) == null ? 0 : map.get(findScore));
        }
    }
}