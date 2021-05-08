import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
class Road{
    int srcVillage;
    int desVillage;
    int price;
    public Road(int srcVillage, int desVillage, int price){
        this.srcVillage = srcVillage;
        this.desVillage = desVillage;
        this.price = price;
    }
}
public class Main{
    private static ArrayList<Road> roads = new ArrayList<>();
    private static int[] father;
    private static int n;
    public static void init(){
        father = new int[n];
        for(int i = 0; i < n; i++)
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
    public static void Kruskal(){
        init();
        int roadCnt = 0;
        int totalCost = 0;
        Collections.sort(roads, new Comparator<Road>(){
            public int compare(Road a, Road b){
                return a.price == b.price ? 0 : a.price < b.price ? -1 : 1;
            }
        });
        for(Road road : roads){
            if(roadCnt == n - 1) break;
            int xx = getFather(road.srcVillage);
            int yy = getFather(road.desVillage);
            if(xx != yy){
                Union(road.srcVillage, road.desVillage);
                totalCost += road.price;
                roadCnt++;
            }
        }
        System.out.println(totalCost);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            n = Integer.valueOf(in.nextLine());
            if(n == 0) break;
            for(int i = 0; i < n - 1; i++){
                String[] tmpStrs = in.nextLine().split(" ");
                int srcVillage = tmpStrs[0].charAt(0) - 'A';
                int roadCnt = Integer.valueOf(tmpStrs[1]);
                for(int j = 2; j < 2 * roadCnt + 2; j++){
                    int desVillage = tmpStrs[j++].charAt(0) - 'A';
                    int price = Integer.valueOf(tmpStrs[j]);
                    roads.add(new Road(srcVillage, desVillage, price));
                }
            }
            Kruskal();
            roads.clear();
        }
    }
}