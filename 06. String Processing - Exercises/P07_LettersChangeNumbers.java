import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by todor on 30.09.2017 г..
 */
public class P07_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split("\\s+");
        BigDecimal sum = BigDecimal.ZERO;
    
        for (String s : input) {
            BigDecimal value = calcEntryValue(s);
            sum = sum.add(value);
        }
    
        System.out.printf("%.2f%n", sum);
    }
    
    private static BigDecimal calcEntryValue(String s) {
        if (s.length() < 3){
            return BigDecimal.ZERO;
        }
        char firstLetter = s.charAt(0);
        char lastLetter = s.charAt(s.length() - 1);
        BigDecimal num = new BigDecimal(s.substring(1, s.length() - 1));
        
        num = Character.isUpperCase(firstLetter) ?
                num.divide(new BigDecimal(firstLetter - 'A' + 1), 3, BigDecimal.ROUND_HALF_UP) :
                num.multiply(new BigDecimal(firstLetter - 'a' + 1));
        num = Character.isUpperCase(lastLetter) ?
                num.subtract(new BigDecimal(lastLetter - 'A' + 1)) :
                num.add(new BigDecimal(lastLetter - 'a' + 1));
        
        return num;
    }
    
    
}
