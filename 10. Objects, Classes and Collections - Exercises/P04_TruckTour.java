import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P04_TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int pumpsCount = Integer.parseInt(br.readLine());
        
        Queue<int[]> track = new ArrayDeque<>(pumpsCount);
        
        for (int i = 0; i < pumpsCount; i++) {
            int[] pumpStation = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            track.offer(pumpStation);
        }
        
        int index = -1;
        for (int i = 0; i < pumpsCount; i++) {
            boolean success = true;
            int fuel = 0;
            for (int[] currentPump : track) {
                fuel += currentPump[0];
                int distance = currentPump[1];
                
                if (fuel < distance){
                    success = false;
                    break;
                }
                
                fuel -= distance;
            }
            
            if (success){
                index = i;
                break;
            }
            
            track.offer(track.poll());
        }
        
        System.out.println(index);
    }
}
