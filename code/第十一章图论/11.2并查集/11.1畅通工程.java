import java.util.Scanner;
public class Main{
    private static int[] father;
    public static void init(int n){
        father = new int[n + 1];
        for(int i = 1; i <= n; i++)
            father[i] = i;
    }
    public static int findFather(int x){
        if(father[x] != x)
            father[x] = findFather(father[x]);
        return father[x];
    }
    public static void Union(int x, int y){
        int xFather = findFather(x);
        int yFather = findFather(y);
        if(xFather != yFather)
            father[yFather] = xFather;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            if(N == 0)
                break;
            init(N);
            int M = in.nextInt();
            for(int i = 0; i < M; i++){
                int x = in.nextInt();
                int y = in.nextInt();
                Union(x, y);
            }
            int res = -1;
            for(int i = 1; i <= N; i++)
                if(father[i] == i)
                    res++;
            System.out.println(res);
        }
    }
}