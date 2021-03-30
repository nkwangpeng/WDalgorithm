import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tarStr = br.readLine();
        tarStr = (tarStr.charAt(0) + "").toUpperCase() + tarStr.substring(1);
        char[] tmpChs = tarStr.toCharArray();
        for(int i = 0; i < tmpChs.length - 1; i++){
            if(tmpChs[i] == ' ' || tmpChs[i] == '\t' || tmpChs[i] == '\r' || tmpChs[i] == '\n')
                tmpChs[i + 1] = (tmpChs[i + 1] + "").toUpperCase().charAt(0);
        }
        String res = String.valueOf(tmpChs);
        System.out.println(res);
    }
}