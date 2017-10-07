import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P02_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Queue<String> kids = new ArrayDeque<>();
        
        kids.addAll(Arrays.asList(br.readLine().split("\\s+")));
        
        int n = Integer.parseInt(br.readLine());
        int counter = 0;
        while (kids.size() > 1){
            counter++;
            if (counter == n){
                System.out.printf("Removed %s%n",kids.poll());
                counter = 0;
            }
            else {
                kids.offer(kids.poll());
            }
        }
        
        System.out.printf("Last is %s%n",kids.poll());
    }
}
