import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
class Section{
    public int start;
    public int end;
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("0")) break;
            int n = Integer.parseInt(line);
            Section[] sections = new Section[n];
            for(int i = 0; i < n; i++){
                sections[i] = new Section();
                String[] tmpStrs = br.readLine().split(" ");
                sections[i].start = Integer.parseInt(tmpStrs[0]);
                sections[i].end = Integer.parseInt(tmpStrs[1]);
            }
            Arrays.sort(sections, new Comparator<Object>(){
                public int compare(Object a, Object b){
                    Section a1 = (Section)a;
                    Section b1 = (Section)b;
                    return a1.end <= b1.end ? -1 : 1;
                }
            });
            int endTime = sections[0].end, res = 1;
            for(int i = 1; i < n; i++){
                if(sections[i].start >= endTime){
                    endTime = sections[i].end;
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}