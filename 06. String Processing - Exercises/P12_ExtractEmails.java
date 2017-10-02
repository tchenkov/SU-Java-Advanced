import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 1.10.2017 г..
 */
public class P12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String text = br.readLine();
        String expression = "(^|(?<=\\s))[A-Za-z]+([0-9]+)?([\\._-][A-z0-9]+)?@\\w+-?\\w+(?:\\.\\w+)+";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        
    }
}
