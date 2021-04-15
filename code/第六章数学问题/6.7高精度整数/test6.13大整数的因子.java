import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
            if(line.equals("-1")) break;
            String res = "";
            BigInteger c = new BigInteger(line);
            for(int i = 9; i >= 2; i--){
                if(c.mod(BigInteger.valueOf(i)).equals(BigInteger.valueOf(0)))
                    res = " " + i + res;
            }
            System.out.println(res.length() == 0 ? "none" : res.substring(1));
        }
	}
}
