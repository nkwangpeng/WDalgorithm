import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
class Node implements Comparable<Node>{
    int distance;
    int nodeId;
    int price;
    public Node(int distance, int nodeId, int price){
        this.distance = distance;
        this.nodeId = nodeId;
        this.price = price;
    }
    @Override
    public int compareTo(Node o){
        return this.distance == o.distance ? this.price == o.price ? 0 : this.price < o.price ? -1 : 1 : this.distance < o.distance ? -1 : 1;
    }
}
public class Main{
    private static int M;
    private static int N;
    private static int[][] dis;
    private static int[][] price;
    private static int[] distance;
    private static int[] cost;
    private static Scanner in = new Scanner(System.in);
    public static void initGraph(){
        dis = new int[N][N];
        price = new int[N][N];
        distance = new int[N];
        cost = new int[N];
        for(int i = 0; i < N; i++){
            cost[i] = (int) 1e9;
            distance[i] = (int)1e9;
            for(int j = 0; j < N; j++){
                dis[i][j] = (int)1e9;
                price[i][j] = (int)1e9;
            }
        }
        for(int i = 0; i < M; i++){
            int srcTown = in.nextInt() - 1;
            int desTown = in.nextInt() - 1;
            int distance = in.nextInt();
            int price1 = in.nextInt();
            if(distance < dis[srcTown][desTown] || distance == dis[srcTown][desTown] && price1 < price[srcTown][desTown]){
                dis[srcTown][desTown] = dis[desTown][srcTown] = distance;
                price[srcTown][desTown] = price[desTown][srcTown] = price1;
            }
        }
    }
    public static void Dijkstra(int s){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        distance[s] = 0;
        cost[s] = 0;
        visit[s] = true;
        q.add(new Node(0, s, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            visit[cur.nodeId] = true;
            for(int i = 0; i < N; i++){
                if(!visit[i] && (distance[i] > distance[cur.nodeId] + dis[cur.nodeId][i] || distance[i] == distance[cur.nodeId] + dis[cur.nodeId][i] && cost[i] > cost[cur.nodeId] + price[cur.nodeId][i])){
                    distance[i] =  distance[cur.nodeId] + dis[cur.nodeId][i];
                    cost[i] = cost[cur.nodeId] + price[cur.nodeId][i];
                    q.add(new Node(distance[i], i, cost[i]));
                }
            }
        }
    }
    public static void main(String[] args){
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            if(N == 0) break;
            initGraph();
            int s = in.nextInt() - 1;
            int e = in.nextInt() - 1;
            Dijkstra(s);
            System.out.println(distance[e] + " " + cost[e]);
        }
    }
}