import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Stream<String> names = Arrays.stream(br.readLine().split("\\s+"));
    
        
        Set<String> letters = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toSet());
    
        Predicate<String> checkFirstLetter = getCheckFirstLetter(letters);
        
        Optional<String> firstName = names
                .filter(checkFirstLetter::test)
                .sorted()
                .findFirst();
        
        if (firstName.isPresent()){
            System.out.println(firstName.get());
        }
        else {
            System.out.println("No match");
        }
    }
    
    private static Predicate<String> getCheckFirstLetter(Set<String> letters) {
        return s -> {
            String firstLetter = String.valueOf(s.charAt(0));
            for (String letter : letters) {
                if (letter.equalsIgnoreCase(firstLetter)){
                    return true;
                }
            }
            return false;
        };
    }
}
