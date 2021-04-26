import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
/*
PriorityQueue<T> p = new PriorityQueue<T>(Comparator<T>);
*/
class Complex{
    public int a;
    public int b;
    public int getVal(){
        return a * a + b * b;
    }
    public Complex(int a, int b){
        this.a = a;
        this.b = b;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PriorityQueue<Complex> q = new PriorityQueue<>(new Comparator<Object>(){
            public int compare(Object a, Object b){
                Complex a1 = (Complex)a;
                Complex b1 = (Complex)b;
                if(a1.getVal() == b1.getVal())
                    return a1.b < b1.b ? -1 : 1;
                else if(a1.getVal() < b1.getVal())
                    return 1;
                return -1;
            }
        });
        int n = Integer.valueOf(in.nextLine());
        for(int i = 0; i < n; i++){
            String str = in.nextLine();
            if(str.charAt(0) == 'P'){
                if(q.isEmpty())
                    System.out.println("empty");
                else{
                    Complex maxC = q.poll();
                    System.out.println(maxC.a + "+i" + maxC.b);
                    System.out.println("SIZE = " + q.size());
                }
            }
            else{
                String[] tmpStrs = str.substring(7).split("\\+i");
                int a = Integer.valueOf(tmpStrs[0]);
                int b = Integer.valueOf(tmpStrs[1]);
                q.add(new Complex(a, b));
                System.out.println("SIZE = " + q.size());
            }
        }
    }
}