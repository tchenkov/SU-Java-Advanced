import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by todor on 13.10.2017 г..
 */
public class P08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numbers = Arrays.stream(br.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        Function<int[], Integer> minRightElement = arr -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i]<min){
                    min = arr[i];
                    minIndex = i;
                }
            }
            
            return minIndex;
        };
    
        System.out.println(minRightElement.apply(numbers));
    }
}
