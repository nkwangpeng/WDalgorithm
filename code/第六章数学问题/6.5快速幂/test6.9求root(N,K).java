import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    // （x*y)%k = ((x%k)*(y%k))%k
    public static long root(long x, long y, long k){
        long ans = 1;
        while(y != 0){
            if((y & 1) == 1){
                ans = (ans * x) % k;
            }
            x = (x * x) % k;
            y >>= 1;
        }
        return ans == 0 ? k : ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            long x = Integer.parseInt(strs[0]);
            long y = Integer.parseInt(strs[1]);
            long k = Integer.parseInt(strs[2]);
            System.out.println(root(x, y, k - 1));
        }
    }
}