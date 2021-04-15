import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            BigInteger res = BigInteger.valueOf(1);
            for(int i = 2; i <= N; i++)
                res = res.multiply(BigInteger.valueOf(i));
		    System.out.println(res);
        }
	}
}
