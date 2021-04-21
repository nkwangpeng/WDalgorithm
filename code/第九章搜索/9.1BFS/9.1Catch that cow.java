import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Fstate{
    int p;
    int t;
    public Fstate(int p, int t){
        this.p = p;
        this.t = t;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int K = in.nextInt();
            System.out.println(BFS(N, K));
        }
    }
    private static int MAX_N = 100000;
    public static int BFS(int N, int K){
        Queue<Fstate> q = new LinkedList<>();
        boolean[] visit = new boolean[MAX_N + 1];
        q.add(new Fstate(N, 0));
        visit[N] = true;
        while(!q.isEmpty()){
            Fstate curState = q.poll();
            if(curState.p == K)
                return curState.t;
            Fstate nxtState;
            int curN = curState.p;
            int curT = curState.t;
            // System.out.println(curState.t);
            if(curN + 1 <= MAX_N && !visit[curN + 1]){
                nxtState = new Fstate(curN + 1, curT + 1);
                q.add(nxtState);
                visit[curN + 1] = true;
            }
            if(curN - 1 >= 0 && !visit[curN - 1]){
                nxtState = new Fstate(curN - 1, curT + 1);
                q.add(nxtState);
                visit[curN - 1] = true;
            }
            if(curN * 2 <= MAX_N && !visit[curN * 2]){
                nxtState = new Fstate(curN * 2, curT + 1);
                q.add(nxtState);
                visit[curN * 2] = true;
            }
        }
        return 0;
    }
}