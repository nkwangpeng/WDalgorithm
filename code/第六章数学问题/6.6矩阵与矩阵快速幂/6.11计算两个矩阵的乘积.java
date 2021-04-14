import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    private static int[][] matrix1 = new int[2][3];
    private static int[][] matrix2 = new int[3][2];
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int[][] resMatrix = new int[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++)
                    resMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        return resMatrix;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            String[] strs = br.readLine().split(" ");
            if(i < 2){
                for(int j = 0; j < 3; j++)
                    matrix1[i][j] = Integer.parseInt(strs[j]);
            } else{
                for(int j = 0; j < 2; j++)
                    matrix2[i - 2][j] = Integer.parseInt(strs[j]);
            }
        }
        int[][] resMatrix = multiplyMatrix(matrix1, matrix2);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++)
                System.out.print(resMatrix[i][j] + " ");
            System.out.println();
        }
    }
}