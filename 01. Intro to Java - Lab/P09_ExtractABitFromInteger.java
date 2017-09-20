import java.util.Scanner;

/**
 * Created by todor on 20.09.2017 г..
 */
public class P09_ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number = scan.nextInt();
        int bitPosition = scan.nextInt();
        
        number = number >> bitPosition;
        int bitValue = number & 1;
    
        System.out.println(bitValue);
    }
}
