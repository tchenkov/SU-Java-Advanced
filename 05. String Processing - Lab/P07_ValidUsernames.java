import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P07_ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        List<String> output = new ArrayList<>();
        while (!input.equals("END")) {
            String expression = "^[\\w-]{3,16}$"; /// doto
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);
            
            if (matcher.find()) {
                output.add("valid");
            }
            else {
                output.add("invalid");
            }
            
            input = scan.nextLine();
        }
        
        if (output.contains("valid")) {
            output.forEach(System.out::println);
        }
    }
}
