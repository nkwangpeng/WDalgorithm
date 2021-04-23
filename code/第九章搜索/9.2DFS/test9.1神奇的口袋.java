import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Main{
    private static int cap = 40;
    private static Integer[] v;
    private static boolean[] visit;
    private static int cnt = 0;
    public static void DFS(int sum, int position){
        for(int i = position; i < v.length; i++){
            if(sum + v[i] > cap || visit[i])
                continue;
            visit[i] = true;
            if(sum + v[i] == cap){
                cnt++;
                DFS(0, 0);
            }
            else{
                DFS(sum + v[i], i + 1);
            }
            visit[i] = false;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        v = new Integer[n];
        visit = new boolean[n];
        Arrays.fill(visit, false);
        for(int i = 0; i < n; i++)
            v[i] = in.nextInt();
        DFS(0, 0);
        System.out.println(cnt);
    }
}