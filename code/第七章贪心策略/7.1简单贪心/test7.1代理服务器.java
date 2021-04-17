import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    public static int getIndex(String[] trueIp, String str, int fromIndex){
        int i = fromIndex;
        for(; i < trueIp.length; i++){
            if(str.equals(trueIp[i])) break;
        }
        return i == trueIp.length ? -1 : i;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);
            String[] agentIp = new String[n];
            for(int i = 0; i < n; i++)
                agentIp[i] = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String[] trueIp = new String[m];
            for(int i = 0; i < m; i++)
                trueIp[i] = br.readLine();
            if(n == 1 && getIndex(trueIp, agentIp[0], 0) != -1){
                System.out.println(-1);
                return;
            }
            int res = 0;
            for(int i = 0; i < m; i++){
                boolean flag = false;
                int maxIndex = 0;
                for(int j = 0; j < n; j++){
                    int findIndex = getIndex(trueIp, agentIp[j], i);
                    if(findIndex == -1){
                        flag = true;
                        break;
                    }
                    else
                        maxIndex = maxIndex < findIndex ? findIndex : maxIndex;
                }
                if(flag) break;
                i = maxIndex - 1;
                res += 1;
            }
            System.out.println(res);
        }
    }
}