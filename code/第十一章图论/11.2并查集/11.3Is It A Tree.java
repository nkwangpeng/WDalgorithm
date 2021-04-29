import java.util.Scanner;
/*
树的定义:
空集或者
1、一个联通分支
2、一个根节点(入度为0)
3、除根节点外每个节点入度为1
*/
public class Main{
    private static final int maxN = 10000;
    private static int[] father = new int[maxN];
    private static int[] inDegree = new int[maxN];
    private static boolean[] visit = new boolean[maxN];
    public static void init(){
        for(int i = 0; i < maxN; i++){
            father[i] = i;
            inDegree[i] = 0;
            visit[i] = false;
        }
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
    public static boolean isTree(){
        int component = 0;
        int root = 0;
        for(int i = 1; i < maxN; i++){
            if(!visit[i])
                continue;
            if(father[i] == i)
                component++;
            if(inDegree[i] == 0)
                root++;
            else if(inDegree[i] > 1)
                return false;
        }
        if(component == 0)
            return true;
        if(component != 1 || root != 1)
            return false;
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int caseCnt = 1;
        init();
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x == -1)
                break;
            if(x == 0){
                System.out.println("Case " + caseCnt++ + (isTree() ? " is a tree." : " is not a tree."));
                init();
            }
            else{
                Union(x, y);
                visit[x] = visit[y] = true;
                inDegree[y]++;
            }
        }
    }
}