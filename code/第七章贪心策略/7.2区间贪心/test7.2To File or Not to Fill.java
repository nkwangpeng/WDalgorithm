import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class Station{
    public double price;
    public int dis;
}
public class Main{
    private static int Cmax;
    private static int D;
    private static int Davg;
    private static int N;
    private static Station[] st;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Cmax = in.nextInt();
        D = in.nextInt();
        Davg = in.nextInt();
        N = in.nextInt();
        st = new Station[N + 1];
        st[N] = new Station();
        st[N].price = 0;
        st[N].dis = D;
        for(int i = 0; i < N; i++){
            st[i] = new Station();
            st[i].price = in.nextDouble();
            st[i].dis = in.nextInt();
        }
        Arrays.sort(st, new Comparator<Object>(){
            public int compare(Object a, Object b){
                Station a1 = (Station)a;
                Station b1 = (Station)b;
                return a1.dis < b1.dis ? -1 : 1;
            }
        });
        if(st[0].dis != 0){
            System.out.println("The maximum travel distance = 0.00");
            return;
        }
        int curStation = 0;
        double sumPrice = 0;
        int maxDis = Cmax * Davg;
        double curGas = 0;
        while(curStation < N){
            double priceMin = Double.MAX_VALUE;
            int selSt = -1;
            for(int i = curStation + 1; i <= N && st[i].dis - st[curStation].dis <= maxDis; i++){
                if(st[i].price < priceMin){
                    priceMin = st[i].price;
                    selSt = i;
                }
                if(priceMin < st[curStation].price) break;
            }
            if(selSt == -1) break;
            double costGas = ((st[selSt].dis - st[curStation].dis) * 1.0) / Davg;
            if(priceMin < st[curStation].price){
                if(costGas > curGas){
                    sumPrice += (costGas - curGas) * st[curStation].price;
                    curGas = 0;
                }
                else curGas -= costGas;
            }
            else{
                sumPrice += (Cmax - curGas) * st[curStation].price;
                curGas = Cmax - costGas;
            }
            curStation = selSt;
        }
        if(curStation == N) System.out.printf("%.2f\n", sumPrice);
        else System.out.printf("The maximum travel distance = %.2f\n", (st[curStation].dis + maxDis) * 1.0);
    }
}