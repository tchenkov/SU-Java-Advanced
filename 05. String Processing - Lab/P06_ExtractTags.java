import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P06_ExtractTags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        
        while (!input.equals("END")){
            String expression = "<.+?>";
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);
            
            while (matcher.find()){
                System.out.println(matcher.group());
            }
    
            input = scan.nextLine();
        }
        
    }
}
