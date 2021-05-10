import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int nodeId;
    long cost;
    public Node(int nodeId, long cost){
        this.nodeId = nodeId;
        this.cost = cost;
    }
}
public class Main{
    private static int N;
    private static ArrayList<Node>[] arr;
    private static int[] inDegree;
    private static long[] earlist;
    private static long[] latest;
    private static long[] time;
    private static long Mod = (long)1e9 + 7;
    public static long criticalPath(){
        long totalCost = 0;
        int[] topoSort = new int[N];
        int topoIndex = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                q.add(i);
                earlist[i] = 0;
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            topoSort[topoIndex++] = u;
            for(int i = 0; i < arr[u].size(); i++){
                int v = arr[u].get(i).nodeId;
                long l = arr[u].get(i).cost;
                inDegree[v]--;
                earlist[v] = Math.max(earlist[v], earlist[u] + l);
                if(inDegree[v] == 0){
                    totalCost = Math.max(totalCost, earlist[v] + time[v]);
                    q.add(v);
                }
            }
        }
        for(int i = N - 1; i >= 0; i--){
            int u = topoSort[i];
            if(arr[u].size() == 0)
                latest[u] = totalCost - time[u];
            else
                latest[u] = Integer.MAX_VALUE;
            for(int j = 0; j < arr[u].size(); j++){
                int v = arr[u].get(j).nodeId;
                long l = arr[u].get(j).cost;
                latest[u] = Math.min(latest[u], latest[v] - l);
            }
        }
        return totalCost;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            int M = in.nextInt();
            inDegree = new int[N];
            arr = new ArrayList[N];
            earlist = new long[N];
            latest = new long[N];
            time = new long[N];
            for(int i = 0; i < N; i++){
                time[i] = in.nextLong();
                inDegree[i] = 0;
                arr[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++){
                int srcNode = in.nextInt() - 1;
                int desNode = in.nextInt() - 1;
                long cost = time[srcNode];
                inDegree[desNode]++;
                arr[srcNode].add(new Node(desNode, cost));
            }
            long res1 = criticalPath();
            long res2 = 1;
            for(int i = 0; i < N; i++)
                res2 = ((res2 % Mod) * (latest[i] - earlist[i] + 1) % Mod) % Mod;
            System.out.println(res1 + "\n" + res2);
        }
    }
}