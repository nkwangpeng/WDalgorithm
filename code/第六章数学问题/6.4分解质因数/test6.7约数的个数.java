import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static int getFactorCnt(int num){
        int res = 0;
        for(int i = 1; i * i <= num; i++)
            if(num % i == 0) res += 2;
        return num == 1 ? 1 : res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            int cnt = Integer.parseInt(line);
            String[] strs = br.readLine().split(" ");
            for(int i = 0; i < cnt; i++){
                int num = Integer.parseInt(strs[i]);
                System.out.println(getFactorCnt(num));
            }
        }
    }
}