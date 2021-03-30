import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] totalStrs = br.readLine().split(" ");
        String lostStr = br.readLine();
        String replStr = br.readLine();
        String res = "";
        for(int i = 0; i < totalStrs.length; i++){
            res += totalStrs[i].equals(lostStr) ? replStr + " " : totalStrs[i] + " ";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}