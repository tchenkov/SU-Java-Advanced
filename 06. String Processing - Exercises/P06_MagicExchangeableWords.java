import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by todor on 30.09.2017 г..
 */
public class P06_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] words = br.readLine().split("\\s+");
        String firstWord = words[0];
        String secondWord = words[1];
        boolean isMagic = true;
        int length = firstWord.length() < secondWord.length() ?
                firstWord.length() :
                secondWord.length();
        
        if (firstWord.chars().distinct().count() != secondWord.chars().distinct().count()) {
            System.out.println("false");
            return;
        }
        
        Map<Character, Character> map = new HashMap();
        for (int i = 0; i < length; i++) {
            Character key = new Character(firstWord.charAt(i));
            Character value = new Character(secondWord.charAt(i));
            if (!map.containsKey(key)) {
                map.put(key, value);
            }
            else if (map.get(key) != value) {
                isMagic = false;
                break;
            }
        }
        
        if (firstWord.length() < secondWord.length()) {
            for (int i = firstWord.length(); i < secondWord.length(); i++) {
                Character value = new Character(secondWord.charAt(i));
                if (!map.containsValue(value)) {
                    isMagic = false;
                    break;
                }
            }
        }
        else {
            for (int i = secondWord.length(); i < firstWord.length(); i++) {
                Character key = new Character(firstWord.charAt(i));
                if (!map.containsKey(key)) {
                    isMagic = false;
                    break;
                }
            }
        }
        
        System.out.println(isMagic ? "true" : "false");
        
    }
}
