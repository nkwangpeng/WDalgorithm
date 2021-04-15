import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
            String[] strs = line.split(" ");
            int a = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);
            String res = "";
            int in = 0;
            for(int i = n; i > 0; i--){
                res = (i * a + in) % 10 + res;
                in = (i * a + in) / 10;
            }
            res = ((in == 0) ? "" : in) + res;
            System.out.println(res);
        }
	}
}
