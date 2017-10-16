import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P06_FindAndSumIntegers {
    private static final Predicate<String> IS_INTEGER = s -> s.matches("-?\\d+");
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Optional<Integer> sum = Arrays.stream(br.readLine().split("\\s+"))
                .filter(IS_INTEGER)
                .map(Integer::valueOf)
                .reduce((n1, n2) -> n1 + n2);
            
        if (sum.isPresent()){
            System.out.printf("%d", sum.get());
        }
        else {
            System.out.println("No match");
        }
    }
}
