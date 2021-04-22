import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class Main{
    private static Integer[] sticks;
    private static boolean[] visit;
    private static int side;
    public static boolean DFS(int sum, int step, int position){
        if(step == 3) return true;
        for(int i = position; i < sticks.length; i++){
            if(visit[i] || sum + sticks[i] > side)
                continue;
            visit[i] = true;
            if(sum + sticks[i] == side) {
                if(DFS(0, step + 1, 0))
                    return true;
            }
            else 
                if(DFS(sum + sticks[i], step, i + 1))
                    return true; 
            visit[i] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int m = in.nextInt();
            if(m < 4){
                System.out.println("no");
                continue;
            }
            int sum = 0;
            sticks = new Integer[m];
            visit = new boolean[m];
            Arrays.fill(visit, false);
            for(int j = 0; j < m; j++){
                sticks[j] = in.nextInt();
                sum += sticks[j];
            }
            side = sum / 4;
            Arrays.sort(sticks, Collections.reverseOrder());
            if(sum % 4 != 0)
                System.out.println("no");
            else if(side < sticks[0]){
                System.out.println("no");
            }
            else if(DFS(0, 0, 0)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}