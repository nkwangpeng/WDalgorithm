import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
class WhiteMouse{
    public String color;
    public int weight;
}
class MyComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        WhiteMouse m1 = (WhiteMouse) a;
        WhiteMouse m2 = (WhiteMouse) b;
        return m1.weight < m2.weight ? 1 : -1;
    }
} 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = Integer.parseInt(in.nextLine());
            WhiteMouse[] ms = new WhiteMouse[count];
            for(int i = 0; i < count; i++){
                String[] strs = in.nextLine().split(" ");
                ms[i] = new WhiteMouse();
                ms[i].color = strs[1];
                ms[i].weight = Integer.parseInt(strs[0]);
            }
            Arrays.sort(ms, new MyComparator());
            for(WhiteMouse mou : ms){
                System.out.println(mou.color);
            }
        }
    }
}