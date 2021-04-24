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
    public static Node creatTree(String preStr, String inStr){
        if(preStr.length() == 0)
            return null;
        char c = preStr.charAt(0);
        int cIndex = inStr.indexOf(c);
        Node root = new Node(c);
        root.setlNode(creatTree(preStr.substring(1, cIndex + 1), inStr.substring(0, cIndex)));
        root.setrNode(creatTree(preStr.substring(cIndex + 1), inStr.substring(cIndex + 1)));
        return root;
    }
    public static void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.getlNode());
        postOrder(root.getrNode());
        System.out.print(root.getValue());
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String preStr = in.nextLine();
        String inStr = in.nextLine();
        postOrder(creatTree(preStr, inStr));
    }
}