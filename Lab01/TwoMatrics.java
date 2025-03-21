import java.util.Scanner;
public class TwoMatrics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        
        inputMatrix(sc, matrix1, rows, cols);     // Nhập ma trận thứ nhất   
        inputMatrix(sc, matrix2, rows, cols);     // Nhập ma trận thứ hai
        addTwoMatrix(matrix1, matrix2, rows, cols);
    }        
    // Hàm nhập ma trận
    public static void inputMatrix(Scanner sc, int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }


    // Hàm cộng 2 ma trận
    public static void addTwoMatrix(int [][]a, int [][]b, int rows, int cols){
        int [][]ans = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                ans[i][j] = a[i][j] + b[i][j];
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}


