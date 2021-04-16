import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
class Mouse{
    public int jj;
    public int ff;
    public double rate;
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("-1 -1")) break;
            String[] strs = line.split(" ");
            int M = Integer.parseInt(strs[0]);
            int N = Integer.parseInt(strs[1]);
            Mouse[] mouses = new Mouse[N];
            for(int i = 0; i < N; i++){
                mouses[i] = new Mouse(); //类数组初始为null
                String[] tmpStrs = br.readLine().split(" ");
                mouses[i].ff = Integer.parseInt(tmpStrs[1]);
                mouses[i].jj = Integer.parseInt(tmpStrs[0]);
                mouses[i].rate = (double)mouses[i].jj / (double)mouses[i].ff;
            }
            Arrays.sort(mouses, new Comparator<Object>(){
                public int compare(Object a, Object b){
                    Mouse a1 = (Mouse)a;
                    Mouse b1 = (Mouse)b;
                    return a1.rate < b1.rate ? 1 : -1;  //不是返回1就是返回-1
                }
            });
            double res = 0;
            for(int i = 0; i < N; i++){
                if(M <= mouses[i].ff){
                    res += M * mouses[i].rate;
                    break;
                }
                M -= mouses[i].ff;
                res += mouses[i].jj;
            }
            System.out.printf("%.3f \n", res);
        }
    }
}