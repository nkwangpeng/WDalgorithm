import java.util.Scanner;
public class Main{
    private static int[] father;
    public static void init(int n){
        father = new int[n + 1];
        for(int i = 1; i <= n; i++)
            father[i] = i;
    }
    public static int getFather(int x){
        if(father[x] != x)
            father[x] = getFather(father[x]);
        return father[x];
    }
    public static void Union(int x, int y){
        int xx = getFather(x);
        int yy = getFather(y);
        if(xx != yy)
            father[yy] = xx;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n == 0) break;
            init(n);
            int m = in.nextInt();
            for(int i = 0; i < m; i++){
                int x = in.nextInt();
                int y = in.nextInt();
                Union(x, y);
            }
            int cnt = 0;
            for(int i = 1; i <= n; i++)
                if(father[i] == i) cnt++;
            System.out.println(cnt == 1 ? "YES" : "NO");
        }
    }
}