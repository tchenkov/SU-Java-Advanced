import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P02_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int operationsCount = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < operationsCount; i++) {
            int[] instruction = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            switch (instruction[0]) {
                case 1:
                    stack.push(instruction[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Integer max = stack.stream().max(Comparator.comparingInt(n -> n)).get();
                    System.out.println(max);
            }
        }
    }
}
