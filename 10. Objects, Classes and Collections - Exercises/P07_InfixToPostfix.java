import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 8.10.2017 г..
 */
public class P07_InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();
        
        for (String token : input) {
            // Number
            if (isNumber(token)) {
                outputQueue.offer(token);
                continue;
            }
            
            // Operator
            if (isOperator(token)) {
                while (!operatorStack.isEmpty() && isEqualOrGreater(operatorStack.peek(), token)) {
                    outputQueue.offer(operatorStack.pop());
                }
                
                operatorStack.push(token);
                continue;
            }
            
            // Left parentheses
            if (token.equals("(")) {
                operatorStack.push(token);
                continue;
            }
            
            // Right parentheses
            if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
                continue;
            }
        }
        
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        
        System.out.println(outputQueue.toString().replaceAll("[\\[\\],]", ""));
    }
    
    private static boolean isEqualOrGreater(String peek, String token) {
        if (peek.equals("(")){
            return false;
        }
        boolean isPeakHigh = peek.equals("*") || peek.equals("/");
        boolean isTokenHigh = token.equals("*") || token.equals("/");
        
        if (!isPeakHigh && isTokenHigh){
            return false;
        }
        
        return true;
    }
    
    private static boolean isOperator(String token) {
        switch (token) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                return false;
        }
    }
    
    private static boolean isNumber(String token) {
        String expression = "(?:^| )(?<num>\\d+|[a-z])(?:$| )";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(token);
        
        return matcher.find();
    }
}
