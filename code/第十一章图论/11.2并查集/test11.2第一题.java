import java.util.Scanner;
public class Main{
    private static final int maxN = 200000;
    private static int[] father = new int[maxN];
    private static boolean[] visit = new boolean[maxN];
    public static void init(){
        for(int i = 0; i < maxN; i++){
            father[i] = i;
            visit[i] = false;
        }
    }
    public static int findFather(int a){
        if(a != father[a])
            father[a] = findFather(father[a]);
        return father[a];
    }
    public static void Union(int x, int y){
        int xx = findFather(x);
        int yy = findFather(y);
        if(xx != yy)
            father[yy] = xx;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        init();
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            Union(x, y);
            visit[x] = visit[y] = true;
        }
        int res = 0;
        for(int i = 0; i < maxN; i++){
            if(!visit[i])
                continue;
            if(i == father[i])
                res++;
        }
        System.out.println(res);
    }
}