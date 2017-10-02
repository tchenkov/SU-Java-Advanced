import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 1.10.2017 г..
 */
public class P11_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder text = new StringBuilder();
        
        String line = br.readLine();
        
        while (!line.equals("END")) {
            text.append(line);
            text.append(String.format("%n"));
            
            line = br.readLine();
        }
        
        String expression = "(?<openingTag><a).+?href=\".*?\".*?(?<tag>>).*?(?<closingTag><\\/a>)";
        Pattern pattern = Pattern.compile(expression, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        
        String[][] regexTags = new String[][]{
                {"closingTag", "[/URL]"},
                {"tag", "]"},
                {"openingTag", "[URL"}
        };
        
        while (matcher.find()) {
            
            for (int i = 0; i < regexTags.length; i++) {
                int startIndex = matcher.start(regexTags[i][0]);
                int endIndex = startIndex + matcher.group(regexTags[i][0]).length();
                
                text = text.replace(startIndex, endIndex, regexTags[i][1]);
            }
    
            matcher = pattern.matcher(text);
        }
    
        System.out.println(text);
    }
}
