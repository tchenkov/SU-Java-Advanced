import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 2.10.2017 г..
 */
public class P16_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder text = new StringBuilder();
        
        String input = br.readLine();
        
        while (!input.equals("END")){
            text.append(input);
    
            input = br.readLine();
        }
        
        String expression = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\\\"]*)|([^\\\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()){
            int groupIndex = matcher.groupCount();
            while (matcher.group(groupIndex) == null){
                groupIndex--;
            }
            
            String link = matcher.group(groupIndex);
            System.out.println(link);
        }
    }
}
