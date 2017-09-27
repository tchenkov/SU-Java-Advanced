import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P05_PascalsTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int size = Integer.parseInt(scan.nextLine());
    
        BigInteger[][] pascalsTriangle = getPascalsTriangle(size);
        printPascalsTriangle(pascalsTriangle);
    }
    
    private static void printPascalsTriangle(BigInteger[][] pascalsTriangle) {
        for (int i = 0; i < pascalsTriangle.length; i++) {
            System.out.println(Arrays.toString(pascalsTriangle[i]).replaceAll("[\\[\\],]", ""));
        }
    }
    
    private static BigInteger[][] getPascalsTriangle(int size) {
        BigInteger[][] pascalsTriangle = new BigInteger[size][];
        for (int i = 0; i < size; i++) {
            pascalsTriangle[i] = new BigInteger[i+1];
            for (int j = 0; j < pascalsTriangle[i].length; j++) {
                if (j == 0 || j == pascalsTriangle[i].length - 1){
                    pascalsTriangle[i][j] = BigInteger.ONE;
                }
                else {
                    pascalsTriangle[i][j] = pascalsTriangle[i - 1][j - 1].add(pascalsTriangle[i - 1][j]);
                }
            }
        }
        
        return pascalsTriangle;
    }
}
