import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] size = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] numbers = new int[size[0]][];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        
        int maxSum = Integer.MIN_VALUE;
        int maxSumI = -1;
        int maxSumJ = -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers[i].length - 1; j++) {
                int currentSum = getCurrentSum(numbers, i, j);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumI = i;
                    maxSumJ = j;
                }
            }
            
        }
        
        printMaxSumSubMatrix(numbers, maxSumI, maxSumJ);
        System.out.println(maxSum);
    }
    
    private static void printMaxSumSubMatrix(int[][] numbers, int maxSumI, int maxSumJ) {
        System.out.printf("%d %d%n", numbers[maxSumI][maxSumJ], numbers[maxSumI][maxSumJ + 1]);
        System.out.printf("%d %d%n", numbers[maxSumI + 1][maxSumJ], numbers[maxSumI + 1][maxSumJ + 1]);
    }
    
    private static int getCurrentSum(int[][] numbers, int i, int j) {
        int sum = 0;
        for (int k = i; k <= i + 1; k++) {
            for (int m = j; m <= j + 1; m++) {
                sum += numbers[k][m];
            }
        }
        
        return sum;
    }
}
