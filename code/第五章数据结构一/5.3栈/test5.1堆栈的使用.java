import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("0")) break;
            int count = Integer.parseInt(line);
            for(int i = 0; i < count; i++){
                line = br.readLine();
                char tmpCh = line.charAt(0);
                switch(tmpCh){
                    case 'A':
                        if(stack.empty()) System.out.println("E");
                        else System.out.println(stack.peek());
                        break;
                    case 'P':
                        stack.push(Integer.parseInt(line.substring(2, line.length())));
                        break;
                    default:
                        if(!stack.empty()) stack.pop();
                }
            }
            System.out.println();
        }
    }
}