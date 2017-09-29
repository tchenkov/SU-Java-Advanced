import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P05_VowelCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
    
        String expression = "[aeiouyAEIOUY]";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(input);
        
        int counter = 0;
        
        while (matcher.find()){
            counter++;
        }
    
        System.out.printf("Vowels: %s%n", counter);
    }
}
