import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.*;
public class Main{
    public static int dd(int a, int b){
        if(b == 0)
            return a;
        return dd(b, a % b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            int num1 = Integer.parseInt(strs[0]);
            int num2 = Integer.parseInt(strs[1]);
            System.out.println(num1 * num2 /dd(num1, num2));
        }
    }
}