import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 4.10.2017 г..
 */
public class P07_FindTheMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]){
                System.out.println(i + 1);
                return;
            }
        }
    
        System.out.println(n);
    }
}
