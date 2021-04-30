import java.util.Scanner;
public class Main{
    private static final int maxN = 27;
    private static int[] father = new int[maxN];
    public static void init(){
        for(int i = 0; i < maxN; i++)
            father[i] = i;
    }
    public static int getRelation(int a, int b){
        int res = 0;
        boolean isRelated = false;
        while(a != father[a]){
            a = father[a];
            res++;
            if(a == b){
                isRelated = true;
                break;
            }
        }
        return isRelated ? res : 0;
    }
    public static void Union(int a, int b, int c){
        if(b >= 0 && b <= 26)
            father[b] = a;
        if(c >= 0 && c <= 26)
            father[c] = a;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        init();
        while(in.hasNext()){
            String[] strs = in.nextLine().split(" ");
            int n = Integer.valueOf(strs[0]);
            int m = Integer.valueOf(strs[1]);
            while(n-- > 0){
                String str = in.nextLine();
                int a = str.charAt(0) - 'A';
                int b = str.charAt(1) - 'A';
                int c = str.charAt(2) - 'A';
                Union(a, b, c);
            }
            while(m-- > 0){
                String str = in.nextLine();
                int a = str.charAt(0) - 'A';
                int b = str.charAt(1) - 'A';
                int rela1 = getRelation(a, b);
                int rela2 = getRelation(b, a);
                if(rela1 == 0 && rela2 == 0)
                    System.out.println("-");
                else if(rela1 > 0){
                    if(rela1 == 1)
                        System.out.println("parent");
                    else if(rela1 == 2)
                        System.out.println("grandparent");
                    else{
                        for(int i = 2; i < rela1; i++)
                            System.out.print("great-");
                        System.out.println("grandparent");
                    }
                }
                else{
                    if(rela2 == 1)
                        System.out.println("child");
                    else if(rela2== 2)
                        System.out.println("grandchild");
                    else{
                        for(int i = 2; i < rela2; i++)
                            System.out.print("great-");
                        System.out.println("grandchild");
                    }
                }
            }
            init();
        }
    }
}