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
public class P06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        int n = Integer.parseInt(br.readLine());
        
        Consumer<int[]> reverse = arr -> {
            for (int i = 0; i < arr.length/2; i++) {
                int mem = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = mem;
            }
        };
        
        reverse.accept(numbers);
    
        Predicate<Integer> filterN = x -> x % n != 0;
        Consumer<Integer> print = num -> System.out.printf("%d ",num);
        
        Arrays.stream(numbers)
                .filter(filterN::test)
                .forEach(print::accept);
    }
}
