import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * Created by todor on 10.10.2017 г..
 */
public class P02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] input = br.readLine().split(", ");
        
        int sum = 0;
    
        Function<String, Integer> parse = s -> Integer.parseInt(s);
    
        for (String numString: input) {
            sum += parse.apply(numString);
        }
    
        System.out.println(String.format("Count = %d", input.length));
        String format = "Sum = %d";
        System.out.println(String.format(format, sum));
    }
}
