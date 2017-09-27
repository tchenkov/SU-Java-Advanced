import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by todor on 27.09.2017 г..
 */
public class P11_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        List<String> strings = new ArrayList<>();
        
        int rotation = Integer.parseInt(scan.nextLine().replaceAll("\\D+", ""));
        
        String command = scan.nextLine();
        int maxLength = 0;
        while (!command.equals("END")) {
            strings.add(command);
            maxLength =
                    command.length() > maxLength ?
                            command.length() :
                            maxLength;
    
            command = scan.nextLine();
        }
        
        char[][] charMatrix = new char[strings.size()][maxLength];
    
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[i].length; j++) {
                try {
                    charMatrix[i][j] = strings.get(i).charAt(j);
                } catch (Exception e) { charMatrix[i][j] = ' '; }
            }
        }
        
        switch (rotation % 360){
            case 0:
                printMatrix(charMatrix);
                break;
            case 90:
                char[][] matrix90 = rotateMatrix90Deg(charMatrix);
                printMatrix(matrix90);
                break;
            case 180:
                char[][] matrix180 = rotateMatrix180Deg(charMatrix);
                printMatrix(matrix180);
                break;
            case 270:
                char[][] matrix270 = rotateMatrix270Deg(charMatrix);
                printMatrix(matrix270);
        }
    }
    
    private static char[][] rotateMatrix270Deg(char[][] charMatrix) {
        char[][] rotated90 = rotateMatrix90Deg(charMatrix);
        return rotateMatrix180Deg(rotated90);
    }
    
    private static char[][] rotateMatrix180Deg(char[][] charMatrix) {
        char[][] result = new char[charMatrix.length][charMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = charMatrix[charMatrix.length - 1- i][charMatrix[i].length - 1 - j];
            }
        }
        
        return result;
    }
    
    private static char[][] rotateMatrix90Deg(char[][] charMatrix) {
        char[][] result = new char[charMatrix[0].length][charMatrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = charMatrix[charMatrix.length - 1 - j][i];
            }
        }
        
        return result;
    }
    
    private static void printMatrix(char[][] charMatrix) {
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[i].length; j++) {
                System.out.print(charMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
