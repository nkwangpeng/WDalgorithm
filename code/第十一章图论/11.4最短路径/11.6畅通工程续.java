import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
/*
邻接矩阵实现
继承Comparable要重写compareTo
*/
// class Node implements Comparable<Node>{
//     int distance;
//     int nodeId;
//     public Node(int distance, int nodeId){
//         this.distance = distance;
//         this.nodeId = nodeId;
//     }
//     @Override
//     public int compareTo(Node o){
//         return this.distance == o.distance ? 0 : this.distance < o.distance ? -1 : 1;
//     }
// }
// public class Main{
//     private static int M;
//     private static int N;
//     private static int[][] dis;
//     private static int[] distance;
//     private static Scanner in = new Scanner(System.in);
//     public static void initGraph(){
//         dis = new int[N][N];
//         distance = new int[N];
//         for(int i = 0; i < N; i++){
//             distance[i] = (int)1e9;
//             for(int j = 0; j < N; j++)
//                 dis[i][j] = (int)1e9;
//         }
//         for(int i = 0; i < M; i++){
//             int srcTown = in.nextInt();
//             int desTown = in.nextInt();
//             int distance = in.nextInt();
//             if(distance < dis[srcTown][desTown])
//                 dis[srcTown][desTown] = dis[desTown][srcTown] = distance;
//         }
//     }
//     public static void Dijkstra(int s){
//         PriorityQueue<Node> q = new PriorityQueue<>();
//         boolean[] visit = new boolean[N];
//         distance[s] = 0;
//         visit[s] = true;
//         q.add(new Node(0, s));
//         while(!q.isEmpty()){
//             Node cur = q.poll();
//             visit[cur.nodeId] = true;
//             for(int i = 0; i < N; i++){
//                 if(!visit[i] && distance[i] > distance[cur.nodeId] + dis[cur.nodeId][i]){
//                     distance[i] =  distance[cur.nodeId] + dis[cur.nodeId][i];
//                     q.add(new Node(distance[i], i));
//                 }
//             }
//         }
//     }
//     public static void main(String[] args){
//         while(in.hasNext()){
//             N = in.nextInt();
//             M = in.nextInt();
//             initGraph();
//             int s = in.nextInt();
//             int e = in.nextInt();
//             Dijkstra(s);
//             System.out.println(distance[e] < (int)1e9 ? distance[e] : -1);
//         }
//     }
// }
/*
邻接表实现
*/
class Node implements Comparable<Node>{
    public int distance;
    public int nodeId;
    public Node(int distance, int nodeId){
        this.distance = distance;
        this.nodeId = nodeId;
    }
    @Override
    public int compareTo(Node o){
        return this.distance == o.distance ? 0 : this.distance < o.distance ? -1 : 1;
    }
}
public class Main{
    private static Scanner in = new Scanner(System.in);
    private static int N;
    private static int M;
    private static int distance[];
    private static ArrayList<Node> graph[];
    public static void initGraph(){
        distance = new int[N];
        graph = new ArrayList[N];
        for(int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < N; i++)
            distance[i] = (int)1e9;
        for(int i = 0; i < M; i++){
            int srcTown = in.nextInt();
            int desTown = in.nextInt();
            int price = in.nextInt();
            graph[srcTown].add(new Node(price, desTown));
            graph[desTown].add(new Node(price, srcTown));
        }
    }
    public static void Dijkstra(int s){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        distance[s] = 0;
        visit[s] = true;
        q.add(new Node(0, s));
        while(!q.isEmpty()){
            Node cur = q.poll();
            visit[cur.nodeId] = true;
            for(Node node : graph[cur.nodeId]){
                if(!visit[node.nodeId] && distance[node.nodeId] > distance[cur.nodeId] + node.distance){
                    distance[node.nodeId] = distance[cur.nodeId] + node.distance;
                    q.add(new Node(distance[node.nodeId], node.nodeId));
                }
            }
        }
    }
    public static void main(String[] args){
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            initGraph();
            int s = in.nextInt();
            int e = in.nextInt();
            Dijkstra(s);
            System.out.println(distance[e] < (int)1e9 ? distance[e] : -1);
        }
    }
}