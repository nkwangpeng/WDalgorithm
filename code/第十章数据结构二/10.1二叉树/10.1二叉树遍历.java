import java.util.Scanner;
class Node{
    private char value;
    private Node lNode;
    private Node rNode;
    public Node(char value){
        this.value = value;
    }
    public Node getlNode(){
        return this.lNode;
    }
    public Node getrNode(){
        return this.rNode;
    }
    public void setlNode(Node lNode){
        this.lNode = lNode;
    }
    public void setrNode(Node rNode){
        this.rNode = rNode;
    }
    public char getValue(){
        return this.value;
    }
    public void setValue(char value){
        this.value = value;
    }
}
public class Main{
    private static int index = 0;
    public static Node creatTree(char[] chs){
        if(chs[index] == '#'){
            index++;
            return null;
        }
        Node root = new Node(chs[index++]);
        root.setlNode(creatTree(chs));
        root.setrNode(creatTree(chs));
        return root;
    }
    public static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.getlNode());
        System.out.print(root.getValue() + " ");
        inOrder(root.getrNode());
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Node root = creatTree(in.nextLine().toCharArray());
        inOrder(root);
    }
}