import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
    public static int[][] powerMatrix(int[][] matrix, int k){
        int[][] resMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++)
            resMatrix[i][i] = 1;
        while(k != 0){
            if((k & 1) == 1){
                resMatrix = multiplyMatrix(resMatrix, matrix);
            }
            k /= 2;
            matrix = multiplyMatrix(matrix, matrix);
        }
        return resMatrix;
    }
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int l = matrix1.length;
        int r = matrix2[0].length;
        int k = matrix2.length;
        int[][] resMatrix = new int[l][r];
        for(int i = 0; i < l; i++){
            for(int j = 0; j < r; j++){
                for(int n = 0; n < k; n++){
                    resMatrix[i][j] += matrix1[i][n] * matrix2[n][j];
                }
            }
        }
        return resMatrix;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine()) != null){
            String[] strs = line.split(" ");
            int P = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[1]);
            int[][] matrix = new int[P][P];
            for(int j = 0; j < P; j++){
                String[] tmpStrs = br.readLine().split(" ");
                for(int n = 0; n < P; n++){
                    matrix[j][n] = Integer.parseInt(tmpStrs[n]);
                }
            }
            matrix = powerMatrix(matrix, k);
            for(int j = 0; j < P; j++){
                for(int n = 0; n < P - 1; n++)
                    System.out.print(matrix[j][n] + " ");
                System.out.println(matrix[j][P - 1]);
            }
        }
    }
}