import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] strs = line.split(" ");
			int a0 = Integer.parseInt(strs[0]), a1 = Integer.parseInt(strs[1]),
				p = Integer.parseInt(strs[2]), q = Integer.parseInt(strs[3]),
				k = Integer.parseInt(strs[4]);
			a0 %= 10000;
			a1 %= 10000;
			p %= 10000;
			q %= 10000;
            if(k <= 1) {
                System.out.println(k == 0 ? a0 : a1);
                return;
            }
            while(k >= 2){
                int tmpInt = a1;
                a1 = ((p * a1) % 10000 + (q * a0) % 10000) % 10000;
                a0 = tmpInt;
                k--;
            }
            System.out.println(a1);
		}
	}
}
