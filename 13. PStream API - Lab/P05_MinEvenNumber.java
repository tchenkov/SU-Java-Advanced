import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.Predicate;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P05_MinEvenNumber {
    private static final Predicate<Double> IS_EVEN = n -> n % 2 == 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        OptionalDouble minEvenNumber = Arrays.stream(br.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(IS_EVEN::test)
                .min();
    
        if (minEvenNumber.isPresent()){
            System.out.printf("%.2f", minEvenNumber.getAsDouble());
        }
        else {
            System.out.println("No match");
        }
    }
}
