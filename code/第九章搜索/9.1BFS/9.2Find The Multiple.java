import java.util.Scanner;

public class Main{
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            flag = false;
            if(n == 0) break;
            DFS(n, 1L, 1);
        }
    }
    public static void DFS(int n, long N, int length){
        if(length > 19 || flag)
            return;
        if(N % n == 0){
            System.out.println(N);
            flag = true;
            return;
        }
        DFS(n, N * 10, length + 1);
        DFS(n, N * 10 + 1, length + 1);
    }
}