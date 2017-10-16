import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P08_BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> boundInterval = Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int lowBound = Math.min(boundInterval.get(0), boundInterval.get(1));
        int highBound = Math.max(boundInterval.get(0), boundInterval.get(1));
        IntStream numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt);
        
        numbers.filter(n -> lowBound <= n && n <= highBound).forEach(n -> System.out.printf("%d ", n));
    }
}
