import java.util.Scanner;
import java.util.HashMap;
class Student{
    public String id;
    public String name;
    public String gender;
    public int age;
    public Student(String id, String name, String gender, int age){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public String toString(){
        return this.id + " " + this.name + " " + this.gender + " " + this.age;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<String, Student> map = new HashMap<>();
        int n = Integer.valueOf(in.nextLine());
        for(int i = 0; i < n; i++){
            String[] strs = in.nextLine().split(" ");
            map.put(strs[0], new Student(strs[0], strs[1], strs[2], Integer.valueOf(strs[3])));
        }
        n = Integer.valueOf(in.nextLine());
        for(int i = 0; i < n; i++){
            String str = in.nextLine();
            if(map.containsKey(str))
                System.out.println(map.get(str));
            else
                System.out.println("No Answer!");
        }
    }
}