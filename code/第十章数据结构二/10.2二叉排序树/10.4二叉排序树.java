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
    public static void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.getVal() + " ");
        preOrder(root.getlNode());
        preOrder(root.getrNode());
    }
    public static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.getlNode());
        System.out.print(root.getVal() + " ");
        inOrder(root.getrNode());
    }
    public static void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.getlNode());
        postOrder(root.getrNode());
        System.out.print(root.getVal() + " ");
    }
    public static void insertNode(Node root, int n){
        if(root.getVal() == n)
            return;
        if(root.getVal() < n && root.getrNode() == null){
            root.setrNode(new Node(n));
            return;
        }
        if(root.getVal() > n && root.getlNode() == null){
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
        int n = 0;
        while(in.hasNext()){
            n = in.nextInt();
            root = new Node(in.nextInt());
            for(int i = 0; i < n - 1; i++)
                insertNode(root, in.nextInt());
            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
        }
    }
}