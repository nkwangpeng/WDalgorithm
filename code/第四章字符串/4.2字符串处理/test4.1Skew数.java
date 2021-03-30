import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int res = 0, strLen = str.length();
            for(int i = 0; i < strLen; i++){
                char tmpCh = str.charAt(i);
                res += (tmpCh - '0') * (Math.pow(2, strLen - i) - 1);
            }
            System.out.println(res);
        }
    }
}