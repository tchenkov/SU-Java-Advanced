import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int maxLength = Integer.parseInt(br.readLine());
        String[] names = br.readLine().split("\\s+");
    
        Predicate<String> lengthFilter = s -> s.length() <= maxLength;
    
        Arrays.stream(names)
                .filter(lengthFilter)
                .forEach(System.out::println);
    }
}
