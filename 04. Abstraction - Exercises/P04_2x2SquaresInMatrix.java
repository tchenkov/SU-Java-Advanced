import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 25.09.2017 г..
 */
public class P04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int[] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = size[0];
        int c = size[1];
        
        char[][] charMatrix = getCharMatrix(r, c, scan);
        
        int squaresCount = getSquaresCount(charMatrix);
    
        System.out.println(squaresCount);
    }
    
    private static int getSquaresCount(char[][] charMatrix) {
        int sum = 0;
        for (int i = 0; i < charMatrix.length - 1; i++) {
            for (int j = 0; j < charMatrix[i].length - 1; j++) {
                if (charMatrix[i][j] == charMatrix[i][j + 1] &&
                    charMatrix[i][j] == charMatrix[i + 1][j] &&
                    charMatrix[i][j] == charMatrix[i +1][j +1]){
                    sum++;
                }
            }
        }
        
        return sum;
    }
    
    private static char[][] getCharMatrix(int r, int c, Scanner scan) {
        char[][] charMatrix = new char[r][c];
        for (int i = 0; i < charMatrix.length; i++) {
            charMatrix[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        
        return charMatrix;
    }
}
