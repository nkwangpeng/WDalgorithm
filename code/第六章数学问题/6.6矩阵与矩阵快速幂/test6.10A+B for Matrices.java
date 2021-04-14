import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static int addMatrix(int[][] matrix1, int[][] matrix2){
        int l = matrix1.length;
        int r = matrix1[0].length;
        int res = 0;
        for(int i = 0; i < l; i++){
            int sum = 0;
            for(int j = 0; j < r; j++)
                sum += matrix1[i][j] + matrix2[i][j];
            res += sum == 0 ? 1 : 0;
        }
        for(int i = 0; i < r; i++){
            int sum = 0;
            for(int j = 0; j < l; j++)
                sum += matrix1[j][i] + matrix2[j][i];
            res += sum == 0 ? 1 : 0;
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            if(line.equals("0")) break;
            String[] strs = line.split(" ");
            int l = Integer.parseInt(strs[0]);
            int r = Integer.parseInt(strs[1]);
            int[][] matrix1 = new int[l][r];
            int[][] matrix2 = new int[l][r];
            for(int i = 0; i < l; i++){
                String[] tmpStrs = br.readLine().split(" ");
                for(int j = 0; j < r; j++)
                    matrix1[i][j] = Integer.parseInt(tmpStrs[j]);
            }
            for(int i = 0; i < l; i++){
                String[] tmpStrs = br.readLine().split(" ");
                for(int j = 0; j < r; j++)
                    matrix2[i][j] = Integer.parseInt(tmpStrs[j]);
            }
            System.out.println(addMatrix(matrix1, matrix2));
        }
    }
}