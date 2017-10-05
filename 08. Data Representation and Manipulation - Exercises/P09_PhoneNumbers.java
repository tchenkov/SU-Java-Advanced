import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 4.10.2017 г..
 */
public class P09_PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder text = new StringBuilder();
        StringBuilder output = new StringBuilder();
        
        String input = br.readLine();
        
        while (!input.equals("END")){
            text.append(input);
            
            input = br.readLine();
        }
        
        String expression = "(?<name>[A-Z][A-Za-z]*)[^+A-Z]*?(?<phoneNumber>\\+?\\d+[(\\d)/.\\-\\s]*\\d+)";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        
        output.append("<ol>");
        boolean isMatchFound = false;
        while (matcher.find()){
            isMatchFound =true;
            String name = matcher.group("name");
            String phone = matcher.group("phoneNumber").replaceAll("[()/.\\-\\s]", "");
            output.append(String.format("<li><b>%s:</b> %s</li>", name, phone));
        }
        output.append("</ol>");
        
        if (isMatchFound){
            System.out.println(output);
        }
        else {
            System.out.println("<p>No matches!</p>");
        }
    }
}
