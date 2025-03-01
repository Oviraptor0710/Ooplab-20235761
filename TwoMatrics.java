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
        
        // Hiển thị hai ma trận
        printMatrix(matrix1, rows, cols);
        printMatrix(matrix2, rows, cols);
                sc.close();
    }
    
    // Hàm nhập ma trận
    public static void inputMatrix(Scanner sc, int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    
    // Hàm in ma trận
    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


