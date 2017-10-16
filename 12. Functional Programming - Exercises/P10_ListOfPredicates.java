import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by todor on 13.10.2017 г..
 */
public class P10_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer endNum = Integer.valueOf(br.readLine());
    
        Integer[] divisors = Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .distinct()
                .sorted(Integer::compare)
                .toArray(Integer[]::new);
    
        int startElement = divisors[divisors.length - 1];
        Predicate<Integer> isDividable = integer -> {
            for (int i = divisors.length - 1; i >= 0; i--) {
                if (integer % divisors[i] == 0){
                    continue;
                }
                else {
                    return false;
                }
            }
            return true;
        };
    
        for (int i = startElement; i <= endNum; i+=startElement) {
            if (isDividable.test(i)){
                System.out.print(String.format("%d ", i));
            }
        }
    }
}
