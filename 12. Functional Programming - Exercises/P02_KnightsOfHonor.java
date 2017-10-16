import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P02_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Consumer<String> print = s -> System.out.println(String.format("Sir %s", s));
    
        Arrays.stream(br.readLine().split("\\s+"))
                .forEach(print::accept);
    }
}
