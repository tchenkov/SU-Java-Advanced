import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] interval = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        String filter = br.readLine();
        
        Function<String, Predicate<Integer>> evenOrOdd = s -> {
            switch (s) {
                case "even":
                    return x -> x % 2 == 0;
                case "odd":
                    return x -> x % 2 != 0;
                default:
                    return null;
            }
        };
    
        Consumer<Integer> print = num -> System.out.printf("%d ",num);
        int start = Math.min(interval[0], interval[1]);
        int end = Math.max(interval[0], interval[1]);
        for (int i = start; i <= end; i++) {
            if (evenOrOdd.apply(filter).test(i)){
                print.accept(i);
            }
        }
    }
}
