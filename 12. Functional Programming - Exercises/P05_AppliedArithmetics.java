import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P05_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<String, Function<Integer, Integer>> operation = s -> {
            switch (s) {
                case "add":
                    return n -> n + 1;
                case "multiply":
                    return n -> n * 2;
                case "subtract":
                    return n -> n - 1;
                default:
                    return null;
            }
        };
    
        Consumer<int[]> print = arr -> System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
        
        String command = br.readLine().toLowerCase();
        while (!command.equals("end")) {
            if (command.equals("print")) {
                    print.accept(numbers);
            }
            else {
                int i = 0;
                for (int n : numbers) {
                    numbers[i] = operation.apply(command).apply(n);
                    i++;
                }
            }
    
            command = br.readLine().toLowerCase();
        }
    }
}
