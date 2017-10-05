import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 5.10.2017 г..
 */
public class P10_SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<StringBuilder> html = new ArrayList<>();
        
        String input = br.readLine();
        
        
        while (!input.equals("END")) {
            html.add(new StringBuilder(editInput(input)));
            
            input = br.readLine();
        }
        
        html.forEach(System.out::println);
    }
    
    private static String editInput(String line) {
        String closingRegEx =
                "^(?<padding>\\s*)?</div>\\s*?<!--\\s*(?<tag>main|header|nav|article|section|aside|footer)\\s*-->";
        Pattern closingPattern = Pattern.compile(closingRegEx);
        Matcher closingMatcher = closingPattern.matcher(line);
        
        if (closingMatcher.find()) {
            return String.format("%s</%s>",
                    closingMatcher.group("padding"),
                    closingMatcher.group("tag")
            );
        }
        
        String openingRegEx =
                "^(?<padding>\\s*)?<div\\s*?(?<before>\\s[^\\s].*?|)?\\s+(?:id|class)\\s*?=\\s*?" +
                "\"(?<tag>main|header|nav|article|section|aside|footer)\"\\s*?(?<after>\\s[^\\s].*?|)?\\s*?>";
        Pattern openingPattern = Pattern.compile(openingRegEx);
        Matcher openingMatcher = openingPattern.matcher(line);

        if (openingMatcher.find()) {
            String attributes = String.format("%s%s",
                    openingMatcher.group("before"),
                    openingMatcher.group("after"))
                    .replaceAll("\\s+", " ");
            
            return String.format("%s<%s%s>",
                    openingMatcher.group("padding"),
                    openingMatcher.group("tag"),
                    attributes
            );

        }
        
        return line;
    }
}
