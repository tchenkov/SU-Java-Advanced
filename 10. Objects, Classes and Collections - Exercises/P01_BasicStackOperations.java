import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P01_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int popCount = commands[1];
        int searchFor = commands[2];
        
        Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .forEach(stack::push);
        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }
        
        if (stack.contains(searchFor)){
            System.out.println(true);
        }
        else if (stack.size() == 0){
            System.out.println(0);
        }
        else {
            Integer min = stack.stream().min(Comparator.comparingInt(i -> i)).get();
            System.out.println(min);
        }
    }
}
