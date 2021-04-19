import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
public class Main{
    /*
    不能将Object[] 转化为String[]，转化的话只能是取出每一个元素再转化。java中的强制类型转换只是针对单个对象的，
    想要偷懒将整个数组转换成另外一种类型的数组是不行的，这和数组初始化时需要一个个来也是类似的。
    */
    /*
    String.join("", )第一个参数为连接的字符，第二个参数为数组或者集合
    */
    private static char[] arr;
    private static HashSet<String> set = new  HashSet<String>();
    public static void swap(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void dfs(int n){
        int arrLen = arr.length;
        if(n == arrLen)
            set.add(new String(arr));
        for(int i = n; i < arrLen; i++){
            swap(n, i);
            dfs(n + 1);
            swap(n, i);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        arr = str.toCharArray();
        dfs(0);
        String[] resStr = new String[set.size()];
        set.toArray(resStr);
        Arrays.sort(resStr);
        System.out.println(String.join("\n", resStr));
    }
}