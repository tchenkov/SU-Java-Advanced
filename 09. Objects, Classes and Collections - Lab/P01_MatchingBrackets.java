import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P01_MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Deque<Integer> stack = new ArrayDeque<>();
        
        String input = br.readLine();
    
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                stack.push(i);
            }
            
            if (input.charAt(i) == ')'){
                System.out.println(input.substring(stack.pop(), i+1));
            }
        }
        
    }
}
