import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String count = "";
        while((count = buffer.readLine()) != null){
            int num = Integer.parseInt(count);
            if(num == 0)
                break;
            String[] strs = new String[num];
            for(int i = 0; i < num; i++){
                strs[i] = buffer.readLine();
            }
            Arrays.sort(strs);
            String[] last = strs[0].split("\\\\"), str2Print = null;
            for(int i = 0; i < num; i++){
                str2Print = strs[i].split("\\\\");
                String bankSpace = "";
                if(i == 0){
                    int strLen = str2Print.length;
                    for(int q = 0; q < strLen; q++){
                        System.out.println(bankSpace + str2Print[q]);
                        bankSpace += "  ";
                    }
                }
                else{
                    int j = 0;
                    int strLen = str2Print.length;
                    while(str2Print[j].equals(last[j])){
                        bankSpace += "  ";
                        j++;
                    }
                    for(int q = j; q < strLen; q++){
                        System.out.println(bankSpace + str2Print[q]);
                        bankSpace += "  ";
                    }
                }
                last = str2Print;
            }
            System.out.println();
        }
    }
}