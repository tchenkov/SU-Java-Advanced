import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P05_Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int packsCount = Integer.parseInt(br.readLine());
        int[] packs = Arrays.stream(br.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int studentsCount = Integer.parseInt(br.readLine());
        
        Arrays.sort(packs);
    
        int minDiff = packs[packsCount - 1] - packs[0];
        for (int i = 0; i <= packsCount - studentsCount; i++) {
            int currentDiff = packs[i + studentsCount - 1] - packs[i];
            if (currentDiff < minDiff){
                minDiff = currentDiff;
            }
        }
    
        System.out.println(String.format("Min Difference is %d.", minDiff));
    }
}
