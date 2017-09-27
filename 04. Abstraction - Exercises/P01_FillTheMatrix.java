import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];
        
        int[][] array = getArray(size, type);
        
        printArray(array, array.length);
    }
    
    private static void printArray(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]).replaceAll("[\\[\\],]", ""));
        }
    }
    
    private static int[][] getArray(int size, String type) {
        int[][] array = new int[size][size];
        if (type.equals("A")){
            fillArrayA(array, size);
        }
        else {
            fillArrayB(array, size);
        }
        
        return array;
    }
    
    private static void fillArrayA(int[][] array, int size) {
        int counter = 0;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                array[i][j] = ++counter;
            }
        }
    }
    
    private static void fillArrayB(int[][] array, int size) {
        int counter = 0;
        for (int j = 0; j < size; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    array[i][j] = ++counter;
                }
            }
            else {
                for (int i = size -1; i >= 0; i--) {
                    array[i][j] = ++counter;
                }
            }
        }
    }
}
