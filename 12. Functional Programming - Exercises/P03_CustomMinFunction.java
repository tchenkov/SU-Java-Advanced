import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Function<Integer[], Integer> minElement = intArray -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer n : intArray) {
                if (n < min){
                    min = n;
                }
            }
            
          return min;
        };
    
        Consumer<Integer> print = System.out::println;
        
        Integer[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        
        print.accept(minElement.apply(numbers));
    }
}
