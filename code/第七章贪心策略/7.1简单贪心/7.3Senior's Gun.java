import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            int count = Integer.parseInt(line);
            for(int i = 0; i < count; i++){
                String[] tmpStrs = br.readLine().split(" ");
                int n = Integer.parseInt(tmpStrs[0]);
                int m = Integer.parseInt(tmpStrs[1]);
                Integer[] weapon = new Integer[n];  //想用Arrays.sort必须使用Integer类型
                int[] defence = new int[m];
                String[] weapons = br.readLine().split(" ");
                String[] defences = br.readLine().split(" ");
                for(int j = 0; j < n; j++)
                    weapon[j] = Integer.parseInt(weapons[j]);
                for(int j = 0; j < m; j++)
                    defence[j] = Integer.parseInt(defences[j]);
                Arrays.sort(weapon, new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return a > b ? -1 : 1;
                    }
                });
                Arrays.sort(defence);
                long res = 0;
                for(int j = 0; j < n && j < m; j++){
                    if(weapon[j] >= defence[j])
                        res += weapon[j] - defence[j];
                    else
                        break;
                    
                }
                System.out.println(res);
            }
        }
    }
}