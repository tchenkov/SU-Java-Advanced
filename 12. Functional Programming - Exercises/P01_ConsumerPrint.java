import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by todor on 12.10.2017 г..
 */
public class P01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Consumer<String> print = System.out::println;
    
        Arrays.stream(br.readLine().split(" "))
                .forEach(print::accept);
    }
}
