import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Created by todor on 13.10.2017 г..
 */
public class P09_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        BiFunction<Integer, Integer, Integer> myComparator = (a, b) -> {
            if (isEven.test(a) && !isEven.test(b)) {
                return -1;
            }
            else {
                return a.compareTo(b);
            }
        };
        
        Integer[] numbers = Arrays.stream(br.readLine().trim().split("\\s+"))
                .map(Integer::valueOf)
                .sorted(Integer::compare)
                .sorted((o1, o2) -> myComparator.apply(o1, o2))
                .toArray(Integer[]::new);
        
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }
}
