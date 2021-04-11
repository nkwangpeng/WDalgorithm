import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static List<String> infixToPastfix(String line){
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < line.length(); i++){
            char tmpCh = line.charAt(i);
            switch(tmpCh){
                case '+':
                case '-':
                    while(!stack.empty()) list.add(stack.pop());
                    stack.push(tmpCh + "");
                    break;
                case '*':
                case '/':
                    while(!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) list.add(stack.pop());
                    stack.push(tmpCh + "");
                    break;
                default:
                    int calFactor = tmpCh - '0';
                    while(i < line.length() - 1 && Character.isDigit(line.charAt(i + 1)))
                        calFactor = 10 * calFactor + (line.charAt(++i) - '0');
                    list.add(calFactor + "");
            }
        }
        while(!stack.empty()) list.add(stack.pop());
        return list;
    }
    public static double calRes(List<String> list){
        Stack<Double> stack = new Stack<>();
        for(String str : list){
            switch(str){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double firFactor = stack.pop();
                    double secFactor = stack.pop();
                    stack.push(secFactor / firFactor);
                    break;
                default:
                    stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            List<String>list = infixToPastfix(line);
            System.out.printf("%.0f", calRes(list));
        }
    }
}