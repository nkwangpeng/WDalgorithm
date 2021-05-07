import java.util.Scanner;
import java.util.Arrays;
class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    private static Scanner in = new Scanner(System.in);
    private static Point[] points;
    private static double[][] dis;
    private static double[] distance;
    private static int N;
    private static boolean[] visit;
    public static void init(int N){
        for(int i = 0; i < N; i++){
            String[] tmpStrs = in.nextLine().split(" ");
            points[i] = new Point(Double.parseDouble(tmpStrs[0]), Double.parseDouble(tmpStrs[1]));
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dis[i][j] = dis[j][i] = Math.sqrt((points[i].x - points[j].x) * (points[i].x - points[j].x) + (points[i].y - points[j].y) * (points[i].y - points[j].y));
            }
        }
    }
    public static double Prim(){
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0;
        double res = 0;
        for(int i = 0; i < N; i++){
            int u = -1;
            double min = Double.MAX_VALUE;
            for(int j = 0; j < N; j++){
                if(!visit[j] && distance[j] < min){
                    u = j;
                    min = distance[j];
                }
            }
            if(u == -1) return -1;
            res += min;
            visit[u] = true;
            for(int j = 0; j < N; j++){
                if(!visit[j] && dis[u][j] < distance[j])
                    distance[j] = dis[u][j];
            }
        }
        return res;
    }
    public static void main(String[] args){
        N = Integer.valueOf(in.nextLine());
        points = new Point[N];
        distance = new double[N];
        dis = new double[N][N];
        visit = new boolean[N];
        init(N);
        System.out.printf("%.2f", Prim());
    }
}