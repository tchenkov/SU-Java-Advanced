import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 21.09.2017 г..
 */
public class P05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        if (numbers.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }
    
        for (int i = 0; i < numbers.length; i += 2) {
            int num1 = numbers[i];
            int num2 = numbers[i + 1];
            boolean isNum1Even = num1 % 2 == 0;
            boolean isNum2Even = num2 % 2 == 0;
            
            if (isNum1Even && isNum2Even){
                System.out.printf("%d, %d -> both are even%n", num1, num2);
                continue;
            }
            if (!isNum1Even && !isNum2Even){
                System.out.printf("%d, %d -> both are odd%n", num1, num2);
                continue;
            }
    
            System.out.printf("%d, %d -> different%n", num1, num2);
        }
    }
}
