import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int nodeId;
    int cost;
    public Node(int nodeId, int cost){
        this.nodeId = nodeId;
        this.cost = cost;
    }
}
public class Main{
    private static int N;
    private static ArrayList<Node>[] arr;
    private static int[] inDegree;
    private static int[] earlist;
    private static int[] latest;
    private static int[] time;
    public static int criticalPath(){
        int totalCost = 0;
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
                int l = arr[u].get(i).cost;
                inDegree[v]--;
                earlist[v] = Math.max(earlist[v], earlist[u] + l);
                if(inDegree[v] == 0){
                    totalCost = Math.max(totalCost, earlist[v]);
                    q.add(v);
                }
            }
        }
        for(int i = N - 1; i >= 0; i--){
            int u = topoSort[i];
            if(arr[u].size() == 0)
                latest[u] = totalCost;
            else
                latest[u] = Integer.MAX_VALUE;
            for(int j = 0; j < arr[u].size(); j++){
                int v = arr[u].get(j).nodeId;
                int l = arr[u].get(j).cost;
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
            earlist = new int[N];
            latest = new int[N];
            time = new int[N];
            for(int i = 0; i < N; i++){
                time[i] = 0;
                inDegree[i] = 0;
                arr[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++){
                int srcNode = in.nextInt();
                int desNode = in.nextInt();
                int cost = in.nextInt();
                inDegree[desNode]++;
                arr[srcNode].add(new Node(desNode, cost));
            }
            int res = criticalPath();
            System.out.println(res + 1);
        }
    }
}