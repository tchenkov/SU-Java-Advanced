import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P02_UpperStrings {
    private static final Function<String,String> TO_UPPERCASE = String::toUpperCase;
    private static final Consumer<String> PRINT = s -> System.out.printf("%s ", s);
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Arrays.stream(br.readLine().split("\\s+"))
                .map(TO_UPPERCASE)
                .forEach(PRINT);
    }
}
