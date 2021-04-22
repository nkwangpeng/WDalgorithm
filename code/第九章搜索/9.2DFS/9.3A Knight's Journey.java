import java.util.Arrays;
import java.util.Scanner;
public class Main{
    private static int p;
    private static int q;
    private static int[][] nxtArr ={{-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2}};
    private static boolean[][] visit = new boolean[30][30];
    public static boolean DFS(int x, int y, int step, String res){
        if(step == p * q){
            System.out.println(res);
            return true;
        }
        for(int i = 0; i < 8; i++){
            int nx = x + nxtArr[i][0];
            int ny = y + nxtArr[i][1];
            char col = (char)(ny + 'A');
            char row = (char)(nx + '1');
            if(nx < 0 || nx >= p || ny < 0 || ny >= q || visit[nx][ny])
                continue;
            visit[nx][ny] = true;
            if(DFS(nx, ny, step + 1, res + col + row))
                return true;
            visit[nx][ny] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 30; j++)
            Arrays.fill(visit[j], false);
            p = in.nextInt();
            q = in.nextInt();
            visit[0][0] = true;
            System.out.println("Scenario #" + (i + 1) + ":");
            if(!DFS(0, 0, 1, "A1")){
                System.out.println("impossible");
            }
            System.out.println();
        }
    }
}