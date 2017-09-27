import java.util.Scanner;

/**
 * Created by todor on 25.09.2017 г..
 */
public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int size = scan.nextInt();
    
        int[][] matrix = getMatrix(size, scan);
        
        int backwardsDiagonalSum = getDiagonalSum(matrix, true);
        int forwardDiagonalSum = getDiagonalSum(matrix, false);
        
        int difference = Math.abs(backwardsDiagonalSum - forwardDiagonalSum);
    
        System.out.println(difference);
    }
    
    private static int getDiagonalSum(int[][] matrix, boolean backwardsDiagonal) {
        int sum = 0;
        if (backwardsDiagonal){
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][i];
            }
        }
        else {
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        
        return sum;
    }
    
    private static int[][] getMatrix(int size, Scanner scan) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               matrix[i][j] = scan.nextInt();
            }
        }
        scan.nextLine();
        return matrix;
    }
}
