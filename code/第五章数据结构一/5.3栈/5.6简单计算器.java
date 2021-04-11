import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    /*
    把栈顶所有优先级比将要入栈的运算符高的运算符都加到list中
    如果运算符优先级相同，也要同样加到list中(有先后顺序)
    所以遇到加减就全出栈
    遇到乘除就出栈直到不是乘除
    */
    public static List<String> infixTransPostfix(String line){
        ArrayList<String> list = new ArrayList<>();
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
                    while (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) list.add(stack.pop());
                    stack.push(tmpCh + "");
                    break;
                default:
                    int calFactor = tmpCh - '0';
                    while(i < line.length() - 1 && Character.isDigit(line.charAt(i + 1))){
                        calFactor = 10 * calFactor + (line.charAt(i + 1) - '0');
                        i++;
                    }
                    list.add(String.valueOf(calFactor));
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
            if(line.equals("0")) break;
            line = line.replace(" ", "");
            List<String> list = infixTransPostfix(line);
            System.out.printf("%.2f\n", calRes(list));
        }
    }
}