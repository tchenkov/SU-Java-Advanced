import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P03_SumMatrixElements {
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
        
        int sum = Arrays.stream(numbers).flatMapToInt(n -> Arrays.stream(n)).sum();
    
        for (int i = 0; i < size.length; i++) {
            System.out.println(size[i]);
        }
        System.out.println(sum);
    }
}
