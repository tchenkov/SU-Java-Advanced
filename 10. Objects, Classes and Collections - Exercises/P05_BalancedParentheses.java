import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P05_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        char[] input = br.readLine().toCharArray();
    
        boolean isBalanced = checkBalanced(input);
    
        System.out.println(isBalanced ? "YES" : "NO");
    }
    
    private static boolean checkBalanced(char[] input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input) {
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '['){
                        return false;
                    }
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '('){
                        return false;
                    }
            }
        }
        
        return true;
    }
}
