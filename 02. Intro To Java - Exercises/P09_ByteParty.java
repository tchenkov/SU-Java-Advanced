import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 22.09.2017 г..
 */
public class P09_ByteParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
        
        int[] numbers = new int[n];
    
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }
        scan.nextLine();
        
        String command = scan.nextLine().toLowerCase();
        
        while (!command.equals("party over")){
            String[] commandArray = command.split("\\s+");
            int instruction = Integer.parseInt(commandArray[0]);
            int position = Integer.parseInt(commandArray[1]);
            
            switch (instruction){
                case -1:
                    flipBitsAt(position, numbers);
                    break;
                case 0:
                    setZeroToBitAt(position, numbers);
                    break;
                case 1:
                    setOneToBitAt(position, numbers);
            }
            
            command = scan.nextLine().toLowerCase();
        }
    
        Arrays.stream(numbers).forEach(System.out::println);
    }
    
    private static void flipBitsAt(int position, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] ^ (1  << position);
        }
    }
    
    private static void setOneToBitAt(int position, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int mask = 1 << position;
            numbers[i] = numbers[i] | mask;
        }
    }
    
    private static void setZeroToBitAt(int position, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int mask = ~(1 << position);
            numbers[i] = numbers[i] & mask;
        }
    }
}
