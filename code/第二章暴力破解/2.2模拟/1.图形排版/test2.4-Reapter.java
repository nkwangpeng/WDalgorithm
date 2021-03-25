import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static String[] draw(String [] s, String[] str, int size, int length, int depth){
        if(depth == 1)
            return str;
        String[] tmp = new String[size * length];
        for(int i = 0; i < tmp.length; i++) tmp[i] = "";
        String bankSpace = "";
        for(int i = 0; i < size; i++) bankSpace += " ";
        for(int i= 0; i < length; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < length; k++)
                    if(s[i].charAt(k) == ' ')
                        tmp[i * size + j] = tmp[i * size + j] + bankSpace;
                    else
                        tmp[i * size + j] = tmp[i * size + j] + str[j];
            }
        }
        return draw(s, tmp, tmp.length, length, depth - 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int size = Integer.parseInt(in.nextLine());
            if(size == 0)
                break;
            String[] str = new String[size];
            for(int i = 0; i < size; i++)
                str[i] = in.nextLine();
            int depth = Integer.parseInt(in.nextLine());
            String[] res = new String[(int)Math.pow(size, depth)];
            for(int i = 0; i < res.length; i++) res[i] = "";
            res = draw(str, str, size, size, depth);
            for(String str1 : res)
                System.out.println(str1);
        }
    }
}