import java.util.Scanner;

/**
 * Created by todor on 20.09.2017 г..
 */
public class P10_ModifyABit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number = scan.nextInt();
        int bitPosition = scan.nextInt();
        int bitNewValue = scan.nextInt();
        
        if (bitNewValue != 0 && bitNewValue != 1){
            System.out.println("error: invalid new bit value");
            return;
        }
        
        int result;
        if (bitNewValue == 0){
            int mask = ~(1 << bitPosition);
            result = number & mask;
        }
        else {
            int mask = 1 << bitPosition;
            result = number | mask;
        }
    
        System.out.println(result);
    }
}
