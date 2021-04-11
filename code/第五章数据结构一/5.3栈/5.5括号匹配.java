import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        ArrayList<Character> chArr = new ArrayList<>();
        ArrayList<Integer> brIndex = new ArrayList<>();
        while((line = br.readLine()) != null){
            System.out.println(line);
            char[] resCh = new char[line.length()];
            Arrays.fill(resCh, ' ');
            for(int i = 0; i < line.length(); i++){
                char tmpCh = line.charAt(i);
                if(tmpCh != '(' && tmpCh != ')')
                    continue;
                if(chArr.isEmpty()){
                    chArr.add(tmpCh);
                    brIndex.add(i);
                }
                else if(chArr.get(chArr.size() - 1) =='(' && tmpCh == ')'){
                    chArr.remove(chArr.size() - 1);
                    brIndex.remove(brIndex.size() - 1);
                }
                else{
                    chArr.add(tmpCh);
                    brIndex.add(i);
                }
            }
            for(int bracIndex : brIndex)
                resCh[bracIndex] = line.charAt(bracIndex) == '(' ? '$' : '?';
            for(char ch : resCh)
                System.out.print(ch);
            System.out.println();
            chArr.clear();
            brIndex.clear();
        }
    }
}