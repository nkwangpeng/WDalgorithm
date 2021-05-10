import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Main{
    private static ArrayList<Integer>[] arr;
    private static int[] inDegree;
    private static int N;
    private static StringBuilder sb;
    public static void TopoSort(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur + 1 + " ");
            for(int i = 0; i < arr[cur].size(); i++){
                inDegree[arr[cur].get(i)]--;
                if(inDegree[arr[cur].get(i)] == 0)
                    q.add(arr[cur].get(i));
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            int M = in.nextInt();
            arr = new ArrayList[N];
            inDegree = new int[N];
            sb = new StringBuilder();
            for(int i = 0; i < N; i++){ 
                arr[i] = new ArrayList<>();
                inDegree[i] = 0;
            }
            for(int i = 0; i < M; i++){
                int srcNode = in.nextInt();
                int desNode = in.nextInt();
                arr[srcNode - 1].add(desNode - 1);
                inDegree[desNode - 1]++;
            }
            TopoSort();
            System.out.println(sb.substring(0, sb.length() - 1));

        }
    }
}