import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Main{
    private static ArrayList<Integer>[] arr;
    private static int[] inDegree;
    private static int N;
    public static boolean TopoSort(){
        Queue<Integer> q= new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }
        int number = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            number++;
            for(int i = 0; i < arr[cur].size(); i++){
                inDegree[arr[cur].get(i)]--;
                if(inDegree[arr[cur].get(i)] == 0)
                    q.add(arr[cur].get(i));
            }
        }
        return N == number;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            int M = in.nextInt();
            if(N == 0) break;
            arr = new ArrayList[N];
            inDegree = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = new ArrayList<>();
                inDegree[i] = 0;
            }
            for(int i = 0; i < M; i++){
                int srcNode = in.nextInt();
                int desNode = in.nextInt();
                arr[srcNode].add(desNode);
                inDegree[desNode]++;
            }
            System.out.println(TopoSort() ? "YES" : "NO");
        }
    }
}