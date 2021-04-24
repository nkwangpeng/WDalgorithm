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
    private static Node root;
    public static void insertNode(Node root, int n){
        if(root.getVal() < n && root.getrNode() == null){
            System.out.println(root.getVal());
            root.setrNode(new Node(n));
            return;
        }
        if(root.getVal() > n && root.getlNode() == null){
            System.out.println(root.getVal());
            root.setlNode(new Node(n));
            return;
        }
        if(root.getVal() < n)
            insertNode(root.getrNode(), n);
        else
            insertNode(root.getlNode(), n);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        root = new Node(in.nextInt());
        System.out.println(-1);
        for(int i = 0; i < n - 1; i++)
            insertNode(root, in.nextInt());
    }
}