import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P03_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numArray = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(br.readLine());
        
        int index = binarySearchRecursion(numArray, target);
        
        System.out.println(index);
    }
    
    private static int binarySearchRecursion(int[] numArray, int target) {
        return binarySearchRecursion(numArray, target, 0, numArray.length - 1);
    }
    
    private static int binarySearchRecursion(int[] numArray, int target, int start, int end) {
        if (target < numArray[start] || numArray[end] < target) {
            return -1;
        }
        
        int middleIndex = (start + end) / 2;
        if (numArray[middleIndex] == target) {
            return middleIndex;
        }
        else if (numArray[middleIndex] < target) {
            return binarySearchRecursion(numArray, target, middleIndex + 1, end);
        }
        else {
            return binarySearchRecursion(numArray, target, start, middleIndex - 1);
        }
    }
}
