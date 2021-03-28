import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
class Student{
    public String name;
    public int index;
    public int score;
}
class MyComparator1 implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Student stu1 = (Student) a;
        Student stu2 = (Student) b;
        return stu1.score != stu2.score ? stu1.score < stu2.score ? -1 : 1 : stu1.index < stu2.index ? -1 : 1;
    }
}
class MyComparator2 implements Comparator{
    @Override
    public int compare(Object a, Object b){
        Student stu1 = (Student) a;
        Student stu2 = (Student) b;
        return stu1.score != stu2.score ? stu1.score > stu2.score ? -1 : 1 : stu1.index < stu2.index ? -1 : 1;
    }
} 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = Integer.parseInt(in.nextLine());
            int orderType = Integer.parseInt(in.nextLine());
            Student[] stus = new Student[count];
            for(int i = 0; i < count; i++){
                String[] strs = in.nextLine().split(" ");
                stus[i] = new Student();
                stus[i].index = i;
                stus[i].name = strs[0];
                stus[i].score = Integer.parseInt(strs[1]);
            }
            Arrays.sort(stus, orderType == 1 ? new MyComparator1() : new MyComparator2());
            for(Student stu : stus){
                System.out.println(stu.name + " " + stu.score);
            }
        }
    }
}