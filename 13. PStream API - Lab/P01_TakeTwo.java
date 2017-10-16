import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P01_TakeTwo {
    
    private static final int INTERVAL_START = 10;
    private static final int INTERVAL_END = 20;
    private static final Predicate<Integer> IS_IN_INTERVAL = x -> INTERVAL_START <= x && x <= INTERVAL_END;
    private static final int MAX_OUTPUT_COUNT = 2;
    private static final Consumer<Integer> PRINT_NUMBER = n -> System.out.print(String.format("%d ", n));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Arrays.stream(br.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(IS_IN_INTERVAL::test)
                .distinct()
                .limit(MAX_OUTPUT_COUNT)
                .forEach(PRINT_NUMBER::accept);
    }
}
