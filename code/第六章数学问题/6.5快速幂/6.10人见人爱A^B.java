import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static int FastPower(int A, int B){
        int ans = 1;
        while(B != 0){
            if(B % 2 == 1){
                ans *= A;
                ans %= 1000;
            }
            B /= 2;
            A *= A;
            A %= 1000;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("0 0")) break;
            String[] strs = line.split(" ");
            int A = Integer.parseInt(strs[0]);
            int B = Integer.parseInt(strs[1]);
            System.out.println(FastPower(A, B));
        }
    }
}