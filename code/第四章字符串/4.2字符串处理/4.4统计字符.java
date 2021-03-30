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
        String queStr;
        while ((queStr = br.readLine()) != null) {
            if (queStr.equals("#")) break;
            String tarStr = br.readLine();
            for(int i = 0; i < queStr.length(); i++){
                char tmpCh = queStr.charAt(i);
                System.out.println(tmpCh + " " + getCount(tmpCh, tarStr));
            }
        }
    }
}