import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P04_AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        OptionalDouble average = Arrays.stream(br.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();
        
        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        }
        else {
            System.out.println("No match");
        }
    }
}
