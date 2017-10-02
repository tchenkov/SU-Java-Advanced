import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P03_TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String bannedWords = scan.nextLine();
        Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(bannedWords.split(", ")));
        
        StringBuilder text = new StringBuilder(scan.nextLine());
    
        for (String word: bannedWordsSet) {
            int startIndex = text.indexOf(word);
            int wordLength = word.length();
            String stars = stringRepeat("*", wordLength);
            
            while (startIndex >= 0){
                text.replace(startIndex, startIndex + wordLength, stars);
                startIndex = text.indexOf(word);
            }
        }
        
        System.out.println(text);
    }
    
    private static String stringRepeat(String repeat, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(repeat);
        }
        
        return result.toString();
    }
}
