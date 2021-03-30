import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = new String[str.length()];
        for(int i = 0; i < str.length(); i++)
            strs[i] = str.substring(i);
        Arrays.sort(strs);
        for(String tmpStr : strs)
            System.out.print(tmpStr + " ");
    }
}