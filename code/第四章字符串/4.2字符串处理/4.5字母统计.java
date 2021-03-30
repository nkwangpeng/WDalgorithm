import java.io.*;

public class Main {
    public static int getCount(char queCh, String tarStr){
        int res = 0;
        for(int i = 0; i < tarStr.length(); i++)
            if(tarStr.charAt(i) == queCh)
                res++;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String queStr = br.readLine();
        for(int i = 0; i < 26 ; i++)
            System.out.println((char)(65 + i) + ":" + getCount((char)(65 + i), queStr));
    }
}