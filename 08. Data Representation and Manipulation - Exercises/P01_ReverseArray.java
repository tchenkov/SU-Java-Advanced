import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P01_ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] numArray = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        reverseArray(numArray);
    
        System.out.println(Arrays.toString(numArray).replaceAll("[\\[\\],]", ""));
    }
    
    private static void reverseArray(int[] numArray) {
        reverseArray(numArray, (numArray.length-1)/2);
    }
    
    private static void reverseArray(int[] numArray, int i) {
        if (i < 0){
            return;
        }
        swap(numArray, i, numArray.length - i - 1);
        i--;
        reverseArray(numArray, i);
    }
    
    private static void swap(int[] numArray, int i, int j) {
        int mem = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = mem;
    }
}
