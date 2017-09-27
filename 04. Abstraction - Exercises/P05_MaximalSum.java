import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 25.09.2017 г..
 */
public class P05_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = size[0];
        int c = size[1];
        
        int[][] intMatrix = getIntMatrix(r, c, scan);
        
        int[] maxIndexes = getMaxMatrix(intMatrix);
        
        System.out.printf("Sum = %d%n", maxIndexes[2]);
        
        for (int i = maxIndexes[0]; i < maxIndexes[0] + 3; i++) {
            for (int j = maxIndexes[1]; j < maxIndexes[1] + 3; j++) {
                System.out.printf("%d ", intMatrix[i][j]);
            }
            System.out.println();
        }
        
        
    }
    
    private static int[] getMaxMatrix(int[][] intMatrix) {
        int[] maxIndexes = new int[3];
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < intMatrix.length - 2; i++) {
            for (int j = 0; j < intMatrix[i].length - 2; j++) {
                int[][] currentMatrix = new int[3][3];
                
                for (int k = i; k <= i + 2; k++) {
                    for (int m = j; m <= j + 2; m++) {
                        currentMatrix[k - i][m - j] = intMatrix[k][m];
                    }
                }
                
                int currentSum = Arrays.stream(currentMatrix).flatMapToInt(n -> Arrays.stream(n)).sum();
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxIndexes[0] = i;
                    maxIndexes[1] = j;
                    maxIndexes[2] = maxSum;
                }
            }
        }
        
        return maxIndexes;
    }
    
    private static int[][] getIntMatrix(int r, int c, Scanner scan) {
        int[][] intMatrix = new int[r][c];
        for (int i = 0; i < intMatrix.length; i++) {
            intMatrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        
        return intMatrix;
    }
}
