import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P02_NestedLoopsToRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        nestedLoopRecursion(n);
    }
    
    private static void nestedLoopRecursion(int n) {
        int[] arr = new int[n];
        nestedLoopRecursion(n, 0, arr);
    }
    
    private static void nestedLoopRecursion(int size, int level,  int[] arr) {
        if (level >= size){
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
            
            return;
        }
    
        for (int i = 1; i <= size; i++) {
            arr[level] = i;
            nestedLoopRecursion(size, level +1, arr);
        }
    }
}
