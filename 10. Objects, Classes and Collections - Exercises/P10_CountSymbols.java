import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by todor on 8.10.2017 г..
 */
public class P10_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        Map<Character, Integer> charsCount = new TreeMap<>();
        
        for (char c: text.toCharArray()) {
            if (!charsCount.containsKey(c)){
                charsCount.put(c, 0);
            }
    
            charsCount.put(c, charsCount.get(c) + 1);
        }
    
        for (Map.Entry<Character, Integer> c: charsCount.entrySet()) {
            System.out.println(String.format("%s: %d time/s", c.getKey(), c.getValue()));
        }
    }
}
