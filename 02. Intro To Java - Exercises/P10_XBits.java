import java.util.Scanner;

/**
 * Created by todor on 23.09.2017 г..
 */
public class P10_XBits {
    
    private static final int NUMBERS_COUNT = 8;
    private static final int NUMBERS_BITS = 32;
    private static final int NUMBERS_SHIFTS = NUMBERS_BITS - 2;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] numbers = new int[NUMBERS_COUNT];
    
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
    
        int shiftsCount = NUMBERS_COUNT - 2;
        int count = 0;
        for (int i = 0; i <shiftsCount ; i++) {
    
            for (int startBit = 0; startBit < NUMBERS_SHIFTS; startBit++) {
                if (checkBits(numbers[i], startBit, false)){
                    
                    if (checkBits(numbers[i + 1], startBit, true)){
                        
                        if (checkBits(numbers[i + 2], startBit, false)){
                            count++;
                        }
                    }
                }
            }
    
        }
    
        System.out.println(count);
    }
    
    private static boolean checkBits(int number, int startBit, boolean flip) {
        if (flip){
            boolean bit1 = ((number >> startBit) & 1) == 0;
            boolean bit2 = ((number >> startBit + 1) & 1) == 1;
            boolean bit3 = ((number >> startBit + 2) & 1) == 0;
            return bit1 && bit2 && bit3;
        }
        boolean bit1 = ((number >> startBit) & 1) == 1;
        boolean bit2 = ((number >> startBit + 1) & 1) == 0;
        boolean bit3 = ((number >> startBit + 2) & 1) == 1;
        return bit1 && bit2 && bit3;
    }
}
