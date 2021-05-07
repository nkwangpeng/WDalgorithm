import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class Road{
    int srcVillage;
    int desVillage;
    int roadLen;
    public Road(int srcVillage, int desVillage, int roadLen){
        this.srcVillage = srcVillage;
        this.desVillage = desVillage;
        this.roadLen = roadLen;
    }
    public Road(int roadLen){
        this.roadLen = roadLen;
    }
}
public class Main{
    private static int[] father;
    private static boolean[] visit;
    private static Road[] roads;
    public static void init(){
        for(int i = 1; i < father.length; i++)
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
            int N = Integer.valueOf(in.nextLine());
            if(N == 0) break;
            father = new int[N + 1];
            visit = new boolean[N + 1];
            int lineCnt = (N * (N - 1)) / 2;
            int toFix = 0;
            int relaVillage = 0;
            roads = new Road[lineCnt];
            init();
            for(int i = 0; i < lineCnt; i++){
                String[] tmpStrs = in.nextLine().split(" ");
                if(Integer.valueOf(tmpStrs[3]) == 1){
                    int srcVillage = Integer.valueOf(tmpStrs[0]);
                    int desVillage = Integer.valueOf(tmpStrs[1]);
                    if(getFather(srcVillage) != getFather(desVillage)){
                        Union(srcVillage, desVillage);
                        relaVillage++;
                    }
                    roads[i] = new Road(Integer.MAX_VALUE);
                }
                else{
                    toFix++;
                    roads[i] = new Road(Integer.valueOf(tmpStrs[0]), Integer.valueOf(tmpStrs[1]), Integer.valueOf(tmpStrs[2]));
                }
            }
            Arrays.sort(roads, new Comparator<Object>(){
                public int compare(Object a, Object b){
                    Road a1 = (Road) a;
                    Road b1 = (Road) b;
                    return a1.roadLen == b1.roadLen ? 0 : a1.roadLen < b1.roadLen ? -1 : 1;
                }
            });
            int roadCnt = relaVillage;
            int minLen = 0;
            for(int i = 0; i < toFix; i++){
                if(roadCnt == N - 1)
                    break;
                int srcVillage = roads[i].srcVillage;
                int desVillage = roads[i].desVillage;
                if(getFather(srcVillage) != getFather(desVillage)){
                    Union(srcVillage, desVillage);
                    roadCnt++;
                    minLen += roads[i].roadLen;
                }
            }
            System.out.println(minLen);
        }
    }
}