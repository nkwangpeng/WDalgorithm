import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            System.out.println(calRes(num));
        }
    }
    public static int calRes(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        return calRes(n-1)+calRes(n-2);
    }
}