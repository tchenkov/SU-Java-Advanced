import java.util.Scanner;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P04_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
    
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) != input.charAt(i)){
                result.append(input.charAt(i));
            }
        }
    
        System.out.println(result);
    }
}
