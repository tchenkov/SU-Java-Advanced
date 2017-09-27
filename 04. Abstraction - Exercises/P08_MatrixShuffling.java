import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 26.09.2017 г..
 */
public class P08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] matrixSize = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = inputMatrix(matrixSize, scan);
    
        String command = scan.nextLine().toLowerCase();
        while (!command.equals("end")){
            if (!command.startsWith("swap ") || command.split("\\s+").length != 5){
                System.out.println("Invalid input!");
                command = scan.nextLine().toLowerCase();
            }
            int[] swapIndexes = Arrays.stream(command.split("\\s+"))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            matrix = swapElements(matrix, swapIndexes);
            
            command = scan.nextLine().toLowerCase();
        }
    }
    
    private static String[][] swapElements(String[][] matrix, int[] swapIndexes) {
        int element1X = swapIndexes[0];
        int element1Y = swapIndexes[1];
        int element2X = swapIndexes[2];
        int element2Y = swapIndexes[3];
        
        try {
            String element1 = matrix[element1X][element1Y];
            String element2 = matrix[element2X][element2Y];
    
            matrix[element1X][element1Y] = element2;
            matrix[element2X][element2Y] = element1;
            
            printMatrix(matrix);
            
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
        
        
        return matrix;
    }
    
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]).  replaceAll("[\\[\\],]", ""));
        }
    }
    
    private static String[][] inputMatrix(int[] matrixSize, Scanner scan) {
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
    
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        
        return matrix;
    }
}
