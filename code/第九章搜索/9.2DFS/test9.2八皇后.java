/*
解法一:
*/
import java.util.Scanner;
public class Main{
    private static boolean[][] visit = new boolean[8][8];
    private static String[] res = new String[92];
    private static int cnt = 0;
    private static StringBuilder sb = new StringBuilder();
    public static boolean Judge(int x, int y){
        for(int i = 0; i < 8; i++)
            if(visit[x][i]) return false;
        for(int i = 0; i < 8; i++)
            if(visit[i][y]) return false;
        for(int i = 0; i <= Math.min(x, y); i++)
            if(visit[x - i][y - i]) return false;
        for(int i = 0; i <= x && y + i < 8; i++)
            if(visit[x - i][y + i]) return false;
        return true;
    }
    public static void DFS(int n){
        if(n == 8){
            res[cnt++] = sb.toString();
            return;
        }
        for(int i = 0; i < 8; i++){
            if(Judge(n, i)){
                visit[n][i] = true;
                sb.append(i + 1);
                DFS(n + 1);
                visit[n][i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DFS(0);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(res[n - 1]);
        }
    }
}
/*
解法二：
*/
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    private static String[] res = new String[92];
    private static int cnt = 0;
    private static int[] position = new int[8];
    public static void DFS(int n){
        if(n == 8){
            res[cnt] = "";
            for(int pos : position)
                res[cnt] += pos + 1;
            cnt++;
            return;
        }
        for(int i = 0; i < 8; i++){
            position[n] = i;
            boolean ok = true;
            for(int j = 0; j < n; j++){
                if(position[j] == i || n - position[n] == j - position[j] || n + position[n] == j + position[j]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                DFS(n + 1);
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DFS(0);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(res[n - 1]);
        }
    }
}