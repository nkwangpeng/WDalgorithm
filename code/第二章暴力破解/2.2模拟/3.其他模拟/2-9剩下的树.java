import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String treeNum = in.nextLine();
        String[] treeNums = treeNum.split(" ");
        int count = Integer.parseInt(treeNums[1]);
        int totalCount = Integer.parseInt(treeNums[0]);
        int res = 0;
        boolean[] isExist = new boolean[totalCount + 1];
        for(int i = 0; i < count; i++){
            String[] dist = in.nextLine().split(" ");
            int leftEdge = Integer.parseInt(dist[0]), rightEdge = Integer.parseInt(dist[1]);
            for(int j = leftEdge; j <= rightEdge; j++)
                isExist[j] = true;
        }
        for(int i = 0; i <= totalCount; i++)
            res += isExist[i] ? 0 : 1;
        System.out.println(res);
    }
}