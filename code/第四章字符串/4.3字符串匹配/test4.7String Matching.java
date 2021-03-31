import java.util.Scanner;
public class Main {
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
        int count = 0;
        int[] next = getNext(pat);
        int i = 0, j = 0;
        while(i < tar.length()){
            if(j == -1 || tar.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
            if(j == pat.length()){
                count++;
                j = next[j];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        System.out.println(KMP(strs[0], strs[1]));
    }
}