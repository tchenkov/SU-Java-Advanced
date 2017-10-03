import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P03_RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] numArray = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int sun = recursiveSum(numArray);
    
        System.out.println(sun);
    }
    
    private static int recursiveSum(int[] numArray) {
        return recursiveSum(numArray, 0);
    }
    
    private static int recursiveSum(int[] numArray, int startIndex) {
        if (startIndex == numArray.length - 1){
            return numArray[startIndex];
        }
        return numArray[startIndex] + recursiveSum(numArray, startIndex + 1);
    }
}
