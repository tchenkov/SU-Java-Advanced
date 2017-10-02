import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by todor on 1.10.2017 г..
 */
public class P08_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder text = new StringBuilder(br.readLine());
        StringBuilder pattern = new StringBuilder(br.readLine());
        
        boolean shakeIt = true;
        
        while (shakeIt) {
            int firstIndex = text.indexOf(pattern.toString());
            int lastIndex = text.lastIndexOf(pattern.toString());
            if (firstIndex + pattern.length() - 1 < lastIndex &&
                    pattern.length() > 0) {
                text = text.delete(lastIndex, lastIndex + pattern.length());
                text = text.delete(firstIndex, firstIndex + pattern.length());
                pattern = pattern.deleteCharAt(pattern.length() / 2);
                System.out.println("Shaked it.");
            }
            else {
                shakeIt = false;
                System.out.println("No shake.");
                System.out.println(text);
            }
        }
    }
}
