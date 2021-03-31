import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static int[] getNext(String pat){
        int[] next = new int[pat.length() + 1];
        int i = 0, j = -1;
        next[0] = j;
        while(i < pat.length()){
            if(j == -1 || pat.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }
            else
                j = next[j];
        }
        return next;
    }
    public static int KMP(String tar, String pat){
        int[] next = getNext(pat);
        int i = 0, j = 0;
        int foundCount = 0;
        while(i < tar.length()){
            if(j == -1 || tar.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
            if(j == pat.length()){
                foundCount++;
                j = next[j];
            }
        }
        return foundCount;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
            String pat = br.readLine();
            String tar = br.readLine();
            System.out.println(KMP(tar, pat));
        }
    }
}