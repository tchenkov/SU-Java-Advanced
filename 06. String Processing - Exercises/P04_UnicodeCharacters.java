import java.util.Scanner;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[] input = scan.nextLine().toCharArray();
    
        StringBuilder result = new StringBuilder();
        for (char ch: input) {
            result.append(String.format("\\u%04x", (int) ch));
        }
    
        System.out.println(result);
    }
}
