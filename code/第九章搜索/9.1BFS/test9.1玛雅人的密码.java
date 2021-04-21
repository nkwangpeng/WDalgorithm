import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/*
正则表达式查找效率比较低
*/
class State{
    public char[] tarArr;
    public int times;
    public State(char[] tarArr, int times){
        this.tarArr = tarArr;
        this.times = times;
    }
}
public class Main{
    public static boolean isFindPwd(char[] tarArr){
        for(int i = 0; i < tarArr.length - 3; i++)
            if(tarArr[i] == '2' && tarArr[i + 1] == '0' && tarArr[i + 2] == '1' && tarArr[i + 3] == '2')
                return true;
        return false;
    }
    public static int BFS(String tarStr){
        if(isFindPwd(tarStr.toCharArray())) return 0;
        Queue<State> q = new LinkedList<>();
        q.add(new State(tarStr.toCharArray(), 0));
        while(!q.isEmpty()){
            State curState = q.poll();
            if(isFindPwd(curState.tarArr))
                return curState.times;
            for(int i = 0; i < tarStr.length() - 1; i++){
                char[] tmpArr = curState.tarArr.clone();
                char tmpCh = tmpArr[i];
                if(tmpCh == tmpArr[i + 1]) continue;
                tmpArr[i] = tmpArr[i + 1];
                tmpArr[i + 1] = tmpCh;
//                 if(isFindPwd(curState.tarArr)) return curState.times + 1;
                State nxtState = new State(tmpArr, curState.times + 1);
                q.add(nxtState);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        in.nextLine();
        System.out.println(BFS(in.nextLine()));
    }
}