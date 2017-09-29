import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 28.09.2017 г..
 */
public class P03_ParseTags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String test = scan.nextLine();
    
        String expression = "<upcase>(?<text>.*?)<\\/upcase>";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(test);
        
        boolean isThereAMatch = matcher.find();
        
        while (isThereAMatch){
            test = test.replace(matcher.group(), matcher.group("text").toUpperCase());
    
            matcher = pattern.matcher(test);
            isThereAMatch = matcher.find();
        }
    
        System.out.println(test);
    }
}
