import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);
            String[] nums = br.readLine().split(" ");
            for(int i = n - 1; i >= 0; i--)
                sb.append(nums[i] + " ");
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }
}