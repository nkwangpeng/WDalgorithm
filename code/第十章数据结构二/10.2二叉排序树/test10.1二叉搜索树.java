/*
二叉排序树的中序遍历为升序序列
因此如果两个二叉排序树的序列格式相同，那么中序遍历一定是相同的。
又因为前序遍历和中序遍历可以确定一个树，则我们只需要比较前序遍历即可，如果相同则序列相同，反之则不相同
*/
import java.util.Scanner;
class Node{
    private int val;
    private Node lNode = null;
    private Node rNode = null;
    public Node(int val){
        this.val = val;
    }
    public void setlNode(Node lNode){
        this.lNode = lNode;
    }
    public void setrNode(Node rNode){
        this.rNode = rNode;
    }
    public void setVal(int val){
        this.val = val;
    }
    public Node getlNode(){
        return this.lNode;
    }
    public Node getrNode(){
        return this.rNode;
    }
    public int getVal(){
        return this.val;
    }
}
public class Main{
    public static boolean isSame(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 == null || root1 == null && root2 != null || root1.getVal() != root2.getVal())
            return false;
        return isSame(root1.getlNode(), root2.getlNode()) && isSame(root1.getrNode(), root2.getrNode());
    }
    public static Node insertNode(Node root, int n){
        if(root == null)
            return new Node(n);
        if(root.getVal() < n)
            root.setrNode(insertNode(root.getrNode(), n));
        else
            root.setlNode(insertNode(root.getlNode(), n));
        return root;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        while(in.hasNext()){
            n = Integer.parseInt(in.nextLine());
            if(n == 0)
                break;
            Node root1 = null;
            String s1 = in.nextLine();
            for(int i = 0; i < s1.length(); i++)
                root1 = insertNode(root1, s1.charAt(i) - '0');
            for(int i = 0; i < n; i++){
                Node root2 = null;
                String s2 = in.nextLine();
                for(int j = 0; j < s2.length(); j++)
                    root2 = insertNode(root2, s2.charAt(j) - '0');
                System.out.println(isSame(root1, root2) ? "YES" : "NO");
            }
        }
    }
}