import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by todor on 26.09.2017 г..
 */
public class P06_SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = size[0];
        int c = size[1];
        
        String[][] matrix = getMatrix(r, c, scan);
        
        List<String> maxSequence = getMaxSequence(matrix);
    
        System.out.println(maxSequence.toString().replaceAll("[\\[\\]]", ""));
    }
    
    private static List<String> getMaxSequence(String[][] matrix) {
        List<String> maxSequence = new ArrayList<>();
        String[] matrixDiagonal = getDiagonal(matrix);
        String[][] matrix90Rotated = getMatrixDiagonalFlip(matrix);
    
        maxSequence = calcMaxSequence(matrixDiagonal, maxSequence);
        maxSequence = calcMaxSequence(matrix90Rotated, maxSequence);
        
        return maxSequence;
    }
    
    private static List<String> calcMaxSequence(String[][] arrayInput, List<String> maxSequence) {
        for (int i = 0; i < arrayInput.length; i++) {
            maxSequence = calcMaxSequence(arrayInput[i], maxSequence);
        }
        
        return maxSequence;
    }
    
    private static List<String> calcMaxSequence(String[] arrayInput, List<String> maxSequence) {
        
        int startIndex = 0;
        int length = 1;
        int maxStartIndex = 0;
        int maxLength = maxSequence.size() < 1 ? 1 : maxSequence.size();
        for (int i = 1; i < arrayInput.length; i++) {
            if (arrayInput[i].equals(arrayInput[i - 1])) {
                length++;
            }
            else {
                startIndex = i;
                length = 1;
            }
            if (length > maxLength) {
                maxLength = length;
                maxStartIndex = i - length + 1;
            }
        }
        
        if (maxLength > maxSequence.size()) {
            maxSequence = Arrays.stream(arrayInput)
                    .skip(maxStartIndex)
                    .limit(maxLength)
                    .collect(Collectors.toList());
        }
        
        return maxSequence;
    }
    
    private static String[][] getMatrixDiagonalFlip(String[][] matrix) {
        String[][] result = new String[matrix[0].length][matrix.length];
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[j][i];
            }
            
        }
        
        return result;
    }
    
    private static String[] getDiagonal(String[][] matrix) {
        int size = Math.min(matrix.length, matrix[0].length);
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = matrix[i][i];
        }
        
        return result;
    }
    
    private static String[][] getMatrix(int r, int c, Scanner scan) {
        String[][] matrix = new String[r][c];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        
        return matrix;
    }
}
