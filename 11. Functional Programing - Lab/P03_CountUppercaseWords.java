import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by todor on 10.10.2017 г..
 */
public class P03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] input = br.readLine().split(" ");
    
        Predicate<String> isFirstCharUpper = s -> s.charAt(0) == Character.toUpperCase(s.charAt(0));
    
        LinkedList<String> firstCharUpper = new LinkedList<>();
        for (String s: input) {
            if (isFirstCharUpper.test(s)){
                firstCharUpper.add(s);
            }
        }
    
        System.out.println(firstCharUpper.size());
        firstCharUpper.forEach(System.out::println);
    }
}
