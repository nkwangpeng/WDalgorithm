import java.io.*;
import java.util.*;
class Inter{
    public long l;
    public long r;
    public int id;
}
class Bridge{
    public long x;
    public int id;
}
public class Main{
    public static int lowerBound(List<Bridge> bridges, long tar){
        int l = 0;
        int r = bridges.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(bridges.get(mid).x >= tar) r = mid - 1;
            else l = mid + 1;
        }
        return l == bridges.size() ? -1 : l;
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long lstL = in.nextLong();
        long lstR = in.nextLong();
        int[] ans = new int[n];
        Inter[] inters = new Inter[n];
        ArrayList<Bridge> bridges = new ArrayList<>();
        inters[0] = new Inter();
        inters[0].l = Long.MAX_VALUE;
        inters[0].r = Long.MAX_VALUE;
        for(int i = 1; i < n; i++){
            long L = in.nextLong();
            long R = in.nextLong();
            inters[i] = new Inter();
            inters[i].l = L - lstR;
            inters[i].r = R - lstL;
            inters[i].id = i;
            lstL = L;
            lstR = R;
        }
        for(int i = 1; i <= m; i++){
            Bridge tmpBridge = new Bridge();
            tmpBridge.x = in.nextLong();
            tmpBridge.id = i;
            bridges.add(tmpBridge);
        }
        Arrays.sort(inters, new Comparator<Object>(){
            public int compare(Object a, Object b){
                Inter a1 = (Inter)a;
                Inter b1 = (Inter)b;
                return a1.r == b1.r ? (a1.l < b1.l ? -1 : 1) : (a1.r < b1.r ? -1 : 1);
            }
        });
        Collections.sort(bridges, new Comparator<Object>(){
            public int compare(Object a, Object b){
                Bridge a1 = (Bridge)a;
                Bridge b1 = (Bridge)b;
                return a1.x < b1.x ? -1 : 1;
            }
        });
        for(int i = 0; i < n - 1; i++){
            long l = inters[i].l;
            long r = inters[i].r;
            int findIndex = lowerBound(bridges, l);
            if(findIndex == -1 || bridges.get(findIndex).x > r){
                System.out.println("No");
                return;
            }
            ans[inters[i].id] = bridges.get(findIndex).id;
            bridges.remove(findIndex);
        }
        System.out.println("Yes");
        for(int i = 1; i < n; i++)
            System.out.print(ans[i] + " ");
        System.out.println();
    }
}