import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P01_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numArray = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        bubbleSort(numArray);
        //selectionSort(numArray);
    
        System.out.println(Arrays.toString(numArray).replaceAll("[\\[\\],]", ""));
    }
    
    private static void swap(int[] numArray, int i, int j) {
        int mem = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = mem;
    }
    
    private static void selectionSort(int[] numArray) {
        boolean swapped = true;
        for (int i = 0; i < numArray.length; i++) {
            if (!swapped){
                break;
            }
            swapped = false;
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < numArray.length; j++) {
                if (numArray[j] < minValue){
                    minValue = numArray[j];
                    minIndex = j;
                    swapped = true;
                }
            }
            
            if (swapped){
                swap(numArray, i, minIndex);
            }
        }
    }
    
    private static void bubbleSort(int[] numArray) {
        boolean swapped = true;
        for (int i = 0; i < numArray.length; i++) {
            if (!swapped){
                break;
            }
            swapped = false;
            for (int j = 1; j < numArray.length - i; j++) {
                if (numArray[j - 1] > numArray[j]){
                    swap(numArray, j - 1, j);
                    swapped = true;
                }
            }
        }
    }
}
