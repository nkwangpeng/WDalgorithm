import java.util.Scanner;
import java.util.PriorityQueue;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            if(q.contains(num))
                continue;
            else
                q.add(num);
        }
        int k = in.nextInt();
        for(int i = 0; i < k - 1; i++)
            q.poll();
        System.out.println(q.poll());
    }
}