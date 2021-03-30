import java.io.*;
import java.math.*;
public class Main {
    static String str1 = "";
    static String str2 = "";
    public static int calFor(char ch1, char ch2, int cIn){
        return ((int)(ch1 - '0') + (int)(ch2 - '0') + cIn) / 10;
    }
    public static int calRes(char ch1, char ch2, int cIn){
        return ((int)(ch1 - '0') + (int)(ch2 - '0') + cIn) % 10;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums1 = br.readLine().split("\\.");
        String[] nums2 = br.readLine().split("\\.");
        int num1Len = nums1[1].length(), num2Len = nums2[1].length();
        if(num1Len < num2Len)
            for(int i = 0; i < num2Len - num1Len; i++)
                nums1[1] += 0;
        else
            for(int i = 0; i < num1Len - num2Len; i++)
                nums2[1] += 0;
        String rev11 = new StringBuilder(nums1[0]).reverse().toString();
        String rev12 = new StringBuilder(nums1[1]).reverse().toString();
        String rev21 = new StringBuilder(nums2[0]).reverse().toString();
        String rev22 = new StringBuilder(nums2[1]).reverse().toString();
        int forInt = 0;
        for(int i = 0; i < rev12.length(); i++){
            str2 += calRes(rev12.charAt(i), rev22.charAt(i), forInt);
            forInt = calFor(rev12.charAt(i), rev22.charAt(i), forInt);
        }
        int firLen = Math.min(rev11.length(), rev21.length());
        for(int i = 0; i < firLen; i++){
            str1 += calRes(rev11.charAt(i), rev21.charAt(i), forInt);
            forInt = calFor(rev11.charAt(i), rev21.charAt(i), forInt);
        }
        String restStr = rev11.length() < rev21.length() ? rev21 : rev11;
        for(int i = 0; i < restStr.length() - firLen; i++){
            str1 += calRes(restStr.charAt(firLen + i), '0', forInt);
            forInt = calFor(restStr.charAt(firLen + i), '0', forInt);
        }
        str1 += forInt == 0 ? "" : forInt;
        System.out.println(new StringBuilder(str1).reverse().toString() + "." + new StringBuilder(str2).reverse().toString());
    }
}