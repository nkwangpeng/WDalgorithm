import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] ants = new int[100];
        Arrays.fill(ants, 2);
        int pos0 = 0;
        int left = 0, right = 0;
        for(int i = 0; i < count; i++){
            String[] strs = br.readLine().split(" ");
            int antSpeed = Integer.parseInt(strs[1]);
            int antPos = Integer.parseInt(strs[0]);
            if(antSpeed == 0)
                pos0 = antPos;
            ants[antPos] = antSpeed;
        }
        for(int i = 0; i < 100; i++){
            if(ants[i] == 2)
                continue;
            if(ants[i] == 1 && i < pos0)
                left++;
            if(ants[i] == -1 && i > pos0)
                right++;
        }
        if(left == right)
            System.out.println("Cannot fall!");
        else if (left > right){
            int k = 0;
            for(int i = 1; i < 100; i++){
                if(ants[i] == 1)  k++;
                if(k == left - right){
                    System.out.println(100 - i);
                    break;
                }
            }
        }
        else{
            int k = 0;
            for(int i = 99; i > 0; i--){
                if(ants[i] == -1)  k++;
                if(k == right - left){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}