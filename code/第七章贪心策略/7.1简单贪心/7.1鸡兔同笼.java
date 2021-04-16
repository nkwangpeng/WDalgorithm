import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            int a = Integer.parseInt(line);
            if((a & 1) == 1)
                System.out.println("0 0");
            else if(a % 4 == 0)
                System.out.println(a / 4 + " " + a / 2);
            else
                System.out.println(a / 4 + 1 + " " + a / 2);
        }
    }
}