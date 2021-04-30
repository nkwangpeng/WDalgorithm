import java.util.Scanner;
import java.util.HashMap;
public class Main{
    private static final int maxN = 1001;
    private static int[] father = new int[maxN];
    private static boolean[] visit = new boolean[maxN];
    private static int[] weight = new int[maxN];
    private static HashMap<String, Integer> name2Id = new HashMap<>();
    private static HashMap<Integer, String> id2Name = new HashMap<>();
    public static void init(){
        for(int i = 0; i < maxN; i++){
            weight[i] = 0;
            father[i] = i;
            visit[i] = false;
        }
        name2Id.clear();
        id2Name.clear();
    }
    public static int findFather(int a){
        if(a != father[a])
            father[a] = findFather(father[a]);
        return father[a];
    }
    public static void Union(String name1, String name2){
        int xx = findFather(name2Id.get(name1));
        int yy = findFather(name2Id.get(name2));
        if(xx != yy)
            father[yy] = xx;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        init();
        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            int N = Integer.valueOf(strs[0]);
            int K = Integer.valueOf(strs[1]);
            for(int i = 0; i < N; i++){
                String[] tmpStrs = in.nextLine().split(" ");
                if(!name2Id.containsKey(tmpStrs[0])){
                    name2Id.put(tmpStrs[0], name2Id.size());
                    id2Name.put(name2Id.size() - 1, tmpStrs[0]);
                }
                if(!name2Id.containsKey(tmpStrs[1])){
                    name2Id.put(tmpStrs[1], name2Id.size());
                    id2Name.put(name2Id.size() - 1, tmpStrs[1]);
                }
                Union(tmpStrs[0], tmpStrs[1]);
                visit[name2Id.get(tmpStrs[0])] = true;
                visit[name2Id.get(tmpStrs[1])] = true;
                weight[name2Id.get(tmpStrs[0])] += Integer.valueOf(tmpStrs[2]);
                weight[name2Id.get(tmpStrs[1])] += Integer.valueOf(tmpStrs[2]);
            }
            
            int gangCnt = 0;
            int[] gangId = new int[maxN];
            for(int i = 0; i < maxN; i++){
                if(!visit[i])
                    continue;
                if(father[i] == i)
                    gangId[gangCnt++] = i;
            }
            int badGangCnt = 0;
            String[] res = new String[maxN];
            for(int i = 0; i < gangCnt; i++){
                int gangRoot = gangId[i];
                int member = 0;
                int gangHead = 0;
                int maxWeight = 0;
                int totalWeight = 0;
                for(int j = 0; j < maxN; j++){
                    if(!visit[j])
                        continue;
                    if(findFather(j) == gangRoot){
                        member++;
                        totalWeight += weight[j];
                        if(weight[j] > maxWeight){
                            maxWeight = weight[j];
                            gangHead = j;
                        }
                    }
                }
                if(member > 2 && totalWeight > 2 * K)
                    res[badGangCnt++] = id2Name.get(gangHead) + " " + member;
            }
            System.out.println(badGangCnt);
            for(int i = 0; i < badGangCnt; i++)
                System.out.println(res[i]);
            init();
        }
    }
}