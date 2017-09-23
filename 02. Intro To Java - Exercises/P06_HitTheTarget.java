import java.util.Scanner;

/**
 * Created by todor on 21.09.2017 г..
 */
public class P06_HitTheTarget {
    
    private final static int MIN_VALUE = 1; // always positive value
    private final static int MAX_VALUE = 20; // always positive value grater than MIN_VALUE
    private final static int MIN_TARGET = MIN_VALUE - MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int targetNumber = Integer.parseInt(scan.nextLine());
        
        if (MIN_TARGET <= targetNumber && targetNumber <= 1) {
            printSubtraction(targetNumber);
        }
        else if (MAX_VALUE <= targetNumber && targetNumber <= MAX_VALUE * 2) {
            printAddition(targetNumber);
        }
        else {
            printAddition(targetNumber);
            printSubtraction(targetNumber);
        }
    }
    
    private static void printAddition(final int TARGET) {
        int leftStart = TARGET <= MAX_VALUE ?
                1 :
                TARGET - MAX_VALUE ;
        int rightStart = TARGET - leftStart;
        final int LENGTH = TARGET <= MAX_VALUE ?
                TARGET - 1 :
                MAX_VALUE;
    
        while (leftStart <= LENGTH) {
            System.out.printf("%d + %d = %d%n", leftStart, rightStart, TARGET);
        
            leftStart++;
            rightStart--;
        }
    }
    
    private static void printSubtraction(final int TARGET) {
        int leftStart = TARGET <= 0 ?
                1 :
                TARGET + 1;
        int rightStart = TARGET <= 0 ?
                Math.abs(TARGET - 1) :
                1;
        final int LENGTH = rightStart - leftStart <= 0 ?
                MAX_VALUE :
                MAX_VALUE + leftStart - rightStart;
        
        while (leftStart <= LENGTH) {
            System.out.printf("%d - %d = %d%n", leftStart, rightStart, TARGET);
            
            leftStart++;
            rightStart++;
        }
    }
}
