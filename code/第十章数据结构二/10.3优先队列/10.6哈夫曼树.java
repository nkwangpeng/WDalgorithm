/*
哈夫曼树的权值即为带权路径长度，sum(层数*权重)
*/
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
            q.add(in.nextInt());
        int res = 0;
        while(q.size() != 1){
            int temp = q.poll() + q.poll();
            q.add(temp);
            res += temp;
        }
        System.out.println(res);
    }
}