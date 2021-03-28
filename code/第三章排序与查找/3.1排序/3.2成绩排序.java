import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
class Student{
    public int id;
    public int score;
}
class MyComparator implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Student stu1 = (Student) a;
        Student stu2 = (Student) b;
        return stu1.score != stu2.score ? stu1.score < stu2.score ? -1 : 1 : stu1.id < stu2.id ? -1 : 1;
    }
} 
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        Student[] stus = new Student[count];
        for(int i = 0; i < count; i++){
            String[] strs = in.nextLine().split(" ");
            stus[i] = new Student();
            stus[i].id = Integer.parseInt(strs[0]);
            stus[i].score = Integer.parseInt(strs[1]);
        }
        Arrays.sort(stus, new MyComparator());
        for(Student stu : stus){
            System.out.println(stu.id + " " + stu.score);
        }
    }
}