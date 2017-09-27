import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int r = scan.nextInt();
        int c = scan.nextInt();
        
        String[][] palindromeMatrix = getPalindromeMatrix(r, c);
    
        printArray(palindromeMatrix, palindromeMatrix.length);
    }
    
    private static String[][] getPalindromeMatrix(int rows, int columns) {
        String[][] matrix = new String[rows][columns];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(Character.toString((char) ('a' + i)));
                sb.append(Character.toString((char) ('a' + j + i)));
                sb.append(Character.toString((char) ('a' + i)));
                
                matrix[i][j] = sb.toString();
                sb = new StringBuilder();
            }
        }
        
        return matrix;
    }
    
    private static void printArray(String[][] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]).replaceAll("[\\[\\],]", ""));
        }
    }
}
