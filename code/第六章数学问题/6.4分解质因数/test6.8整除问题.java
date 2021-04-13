import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
public class Main {
    private static int[] prime;
    private static boolean[] isPrime;
    public static int initIsPrime(int a){
        int len = 0;
        isPrime = new boolean[a];
        prime = new int[a];
        Arrays.fill(isPrime, true);
        for(int i = 2; i < a; i++){
            if(isPrime[i]) prime[len++] = i;
            for(int j = 0; j < len & (i * prime[j]) < a; j++){
                isPrime[i * prime[j]] = false;
                if(i % prime[j] == 0) break;
            }
        }
        return len;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            int n = Integer.parseInt(strs[0]);
            int a = Integer.parseInt(strs[1]);
            int len = initIsPrime(a + 1);
            int[] facValue = new int[a + 1];
            int[] facCount = new int[a + 1];
            int cnt = 0;
            for(int i = 0; i < len; i++){
                if(a % prime[i] == 0){
                    facValue[cnt++] = prime[i];
                    while(a % prime[i] == 0){
                        facCount[prime[i]]++;
                        a /= prime[i];
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < cnt; i++){
                int base = facValue[i], sum = 0;
                while(base <= n){
                    sum += n / base;
                    base *= facValue[i];
                }
                if(sum < res) res = sum;
            }
            System.out.println(res);
        }
    }
}