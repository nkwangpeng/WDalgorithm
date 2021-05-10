import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Node{
    int nodeId;
    int distance;
    public Node(int nodeId, int distance){
        this.nodeId = nodeId;
        this.distance = distance;
    }
}
public class Main{
    private static int N;
    private static int[] distance;
    private static int[][] dis;
    private static int[] father;
    public static void init(){
        father = new int[N];
        for(int i = 0; i < N; i++)
            father[i] = i;
    }
    public static int getFather(int x){
        if(father[x] != x)
            father[x] = getFather(father[x]);
        return father[x];
    }
    public static void Union(int x, int y, int z){
        int xx = getFather(x);
        int yy = getFather(y);
        if(xx != yy){
            father[yy] = xx;
            dis[x][y] = dis[y][x] = z;
        }
    }
    public static void bfs(){
        boolean[] visit = new boolean[N];
        distance[0] = 0;
        visit[0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0; i < N; i++){
                if(!visit[i] && distance[i] > cur.distance + dis[cur.nodeId][i]){
                    distance[i] = cur.distance + dis[cur.nodeId][i];
                    q.add(new Node(i, distance[i]));
                    visit[i] = true;
                }
            }
        }
    }
    public static int fastE(long x, int y, int z){
        long ans = 1;
        while(y != 0){
            if((y & 1) == 1){
                ans *= x;
                ans %= z;
            }
            y /= 2;
            x *= x;
            x %= z;
        }
        return (int)ans;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            distance = new int[N];
            dis = new int[N][N];
            for(int i = 0; i < N; i++){
                distance[i] = (int) 1e9;
                for(int j = 0; j < N; j++)
                    dis[i][j] = (int) 1e9;
            }
            init();
            int M = in.nextInt();
            for(int i = 0; i < M; i++){
                int srcCity = in.nextInt();
                int desCity = in.nextInt();
                int z = fastE(2, i, 100000);
                Union(srcCity, desCity, z);
            }
            bfs();
            for(int i = 1; i < N; i++)
                System.out.println(distance[i] == (int) 1e9 ? -1 : distance[i] % 100000);
        }
    }
}