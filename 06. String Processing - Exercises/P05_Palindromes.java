import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        
        String expression = "[^\\s,.?!]+";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        boolean isMachFound = matcher.find();
        Set<String> palindromes = new TreeSet<>();
        
        while (isMachFound){
            String word = matcher.group();
            StringBuilder wordReversed = new StringBuilder(word).reverse();
            
            if (word.equals(wordReversed.toString())){
                palindromes.add(word);
            }
            isMachFound = matcher.find();
        }
    
        System.out.println(palindromes.toString());
    }
}
