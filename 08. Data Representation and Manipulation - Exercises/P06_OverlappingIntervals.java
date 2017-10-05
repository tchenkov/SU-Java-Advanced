import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by todor on 4.10.2017 г..
 */
public class P06_OverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int intervalsCount = Integer.parseInt(br.readLine());
        int[][] intervalsArray = new int[intervalsCount][2];
    
        for (int i = 0; i < intervalsCount; i++) {
            intervalsArray[i] = Arrays.stream(br.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        
        Arrays.sort(intervalsArray, Comparator.comparingInt(e -> e[0]));
        
        boolean isOverlapping = isThereOverlappingIntervals(intervalsArray);
    
        System.out.println(isOverlapping);
    }
    
    private static boolean isThereOverlappingIntervals(int[][] intervalsArray) {
        for (int i = 0; i < intervalsArray.length - 1; i++) {
            for (int j = i + 1; j < intervalsArray.length; j++) {
                boolean isOverlapping = checkForOverlapping(intervalsArray[i], intervalsArray[j]);
                if (isOverlapping){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean checkForOverlapping(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[1] && interval1[1] >= interval2[0];
    }
}
